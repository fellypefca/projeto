package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import modelo.Departamento;

@Transactional
public class JPADepartamentoDAO implements DepartamentoDAO {
	
	private final EntityManager manager;
	
	@Inject
	public JPADepartamentoDAO(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @deprecated para o CDI
	 */
	JPADepartamentoDAO() { this(null); }
	
	

	@Override
	public void adiciona(Departamento departamento) {
		if (departamento.getId() == null) 
		{
			this.manager.persist(departamento);
		} else {
			this.manager.merge(departamento);
		}	
		
	}

	@Override
	public List<Departamento> todos() {
		return this.manager
				.createQuery("select d from Departamento d", Departamento.class)
				.getResultList();
	}

	@Override
	public Departamento buscaPorSigla(String sigla) {
		try {
			return this.manager.createQuery("select d from Departamento d where d.sigla = :sigla", Departamento.class)
					.setParameter("sigla", sigla)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
