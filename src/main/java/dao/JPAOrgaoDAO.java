package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import modelo.Orgao;

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
	public void adiciona(Orgao orgao) {
		if (orgao.getId() == null) 
		{
			this.manager.persist(orgao);
		} else {
			this.manager.merge(orgao);
		}	
		
	}

	@Override
	public List<Orgao> todos() {
		return this.manager
				.createQuery("select o from Orgao o", Orgao.class)
				.getResultList();
	}

	@Override
	public Orgao buscaPorCnpj(String cnpj) {
		try {
			return this.manager.createQuery("select o from Orgao o where o.cnpj = :cnpj", Orgao.class)
					.setParameter("cnpj", cnpj)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}