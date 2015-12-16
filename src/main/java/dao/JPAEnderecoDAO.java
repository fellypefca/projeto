package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import modelo.Categoria;
import modelo.Endereco;

@Transactional
public class JPAEnderecoDAO implements EnderecoDAO {
	
	private final EntityManager manager;
	
	@Inject
	public JPAEnderecoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	/**
	 * @deprecated para o CDI
	 */
	
	JPAEnderecoDAO() { this(null); }

	@Override
	public void adiciona(Endereco e) {
		if (e.getId() == null) 
		{
			this.manager.persist(e);
		} else {
			this.manager.merge(e);
		}	
		
	}

	@Override
	public List<Endereco> todos() {
		return this.manager
				.createQuery("select e from Endereco e", Endereco.class)
				.getResultList();
	}

	@Override
	public Endereco buscaPorEndereco(Long id) {
		try {
			return this.manager.createQuery("select e from Endereco e where e.id = :id", Endereco.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void remover(Endereco endereco) {
		Endereco EndASerRemovido = manager.getReference(Endereco.class, endereco.getId());
		 this.manager.remove(EndASerRemovido);
	}

}
