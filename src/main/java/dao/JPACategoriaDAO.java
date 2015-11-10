package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import modelo.Categoria;

@Transactional
public class JPACategoriaDAO implements CategoriaDAO {
	
	private final EntityManager manager;
	
	@Inject
	public JPACategoriaDAO(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @deprecated para o CDI
	 */
	JPACategoriaDAO() { this(null); }

	@Override
	public void adiciona(Categoria cat) {
		if (cat.getId() == null) 
		{
			this.manager.persist(cat);
		} else {
			this.manager.merge(cat);
		}	
	}

	@Override
	public List<Categoria> todos() {
		return this.manager
				.createQuery("select c from Categoria c", Categoria.class)
				.getResultList();
	}

	@Override
	public Categoria buscaPorCategoria(String tipo) {
		try {
			return this.manager.createQuery("select c from Categoria c where c.tipo = :tipo", Categoria.class)
					.setParameter("tipo", tipo)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}