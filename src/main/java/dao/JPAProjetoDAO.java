package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import modelo.Projeto;

@Transactional
public class JPAProjetoDAO implements ProjetoDAO {
	
	private final EntityManager manager;
	
	@Inject
	public JPAProjetoDAO(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @deprecated para o CDI
	 */
	JPAProjetoDAO() { this(null); }

	@Override
	public void adiciona(Projeto projeto) {
		if (projeto.getId() == null) 
		{
			this.manager.persist(projeto);
		} else {
			this.manager.merge(projeto);
		}	
	}

	@Override
	public List<Projeto> todos() {
		return this.manager
				.createQuery("select p from Projeto p", Projeto.class)
				.getResultList();
	}

	@Override
	public Projeto buscaPorTitulo(String titulo) {
		try {
			return this.manager.createQuery("select p from Projeto p where p.titulo = :titulo", Projeto.class)
					.setParameter("titulo", titulo)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}