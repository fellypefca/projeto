package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import modelo.OrgaoFinanciador;

@Transactional
public class JPAOrgaoDAO implements OrgaoDAO{
	
	private final EntityManager manager;
	
	@Inject
	public JPAOrgaoDAO(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @deprecated para o CDI
	 */
	JPAOrgaoDAO() { this(null); }
	
	

	@Override
	public void adiciona(OrgaoFinanciador Orgao) {
		if (Orgao.getId() == null) 
		{
			this.manager.persist(Orgao);
		} else {
			this.manager.merge(Orgao);
		}	
		
	}

	@Override
	public List<OrgaoFinanciador> todos() {
		return this.manager
				.createQuery("select d from OrgaoFinanciador d", OrgaoFinanciador.class)
				.getResultList();
	}

	@Override
	public OrgaoFinanciador buscaPorNome(String nome) {
		try {
			return this.manager.createQuery("select d from Orgao d where d.nome = :nome", OrgaoFinanciador.class)
					.setParameter("nome", nome)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
