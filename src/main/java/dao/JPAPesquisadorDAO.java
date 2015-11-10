package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import modelo.Categoria;
import modelo.Departamento;
import modelo.Pesquisador;

@Transactional
public class JPAPesquisadorDAO implements PesquisadorDAO {
	
private final EntityManager manager;
	
	@Inject
	public JPAPesquisadorDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	/**
	 * @deprecated para o CDI
	 */
	
	JPAPesquisadorDAO() { this(null); }



	@Override
	public void adiciona(Pesquisador pesquisador) {
		if (pesquisador.getId() == null) 
		{
			this.manager.persist(pesquisador);
		} else {
			this.manager.merge(pesquisador);
		}	
	}
	
	@Override
	public List<Pesquisador> todos() {
		return this.manager
				.createQuery("select p from Pesquisador p", Pesquisador.class)
				.getResultList();
	}

	@Override
	public Pesquisador buscaPorCPF(String cpf) {
		try {
			return this.manager.createQuery("select p from Pesquisador p where p.cpf = :cpf", Pesquisador.class)
					.setParameter("cpf", cpf)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Categoria> listaCategoria() {
		return this.manager
				.createQuery("select c from Categoria c", Categoria.class)
				.getResultList();
	}
	
	public List<Departamento> listaDepartamento() {
		return this.manager
				.createQuery("select d from Departamento d", Departamento.class)
				.getResultList();
	}
}
