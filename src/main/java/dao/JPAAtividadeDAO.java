package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import modelo.Atividade;


@Transactional
public class JPAAtividadeDAO implements AtividadeDAO {
	
	private final EntityManager manager;
	
	@Inject
	public JPAAtividadeDAO(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @deprecated para o CDI
	 */
	JPAAtividadeDAO() { this(null); }

	@Override
	public void adiciona(Atividade at) {
		if (at.getId() == null) 
		{
			this.manager.persist(at);
		} else {
			this.manager.merge(at);
		}	
	}

	@Override
	public List<Atividade> todos() {
		return this.manager
				.createQuery("select a from Atividade a", Atividade.class)
				.getResultList();
	}

	@Override
	public void remover(Atividade Atividade) {
		 Atividade atASerRemovida = manager.getReference(Atividade.class, Atividade.getId());
		 this.manager.remove(atASerRemovida);
		
	}
	@Override
	public Atividade buscaPorId(Long id) {
		try {
			return this.manager.createQuery("select a from Atividade a where a.id = :id", Atividade.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}