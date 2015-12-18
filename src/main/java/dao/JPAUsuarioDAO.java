package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import modelo.Usuario;

@Transactional
public class JPAUsuarioDAO implements UsuarioDAO {
	
	private final EntityManager manager;
	
	@Inject
	public JPAUsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @deprecated para o CDI
	 */
	JPAUsuarioDAO() { this(null); }

	@Override
	public void adiciona(Usuario usuario) {
		if (usuario.getId() == null) 
		{
			this.manager.persist(usuario);
		} else {
			this.manager.merge(usuario);
		}	
		
	}

	@Override
	public List<Usuario> todos() {
		return this.manager
				.createQuery("select u from Usuario u", Usuario.class)
				.getResultList();
	}

	@Override
	public Usuario buscaPorCPF(String cpf) {
		try {
			return this.manager.createQuery("select u from Usuario u where u.cpf = :cpf", Usuario.class)
					.setParameter("cpf", cpf)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void remover(Usuario usuario) {
			 Usuario UserASerRemovido = manager.getReference(Usuario.class, usuario.getId());
			 this.manager.remove(UserASerRemovido);
	}

}
