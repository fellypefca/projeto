package cadastrabd;

import java.util.List;

import javax.inject.Inject;
import dao.UsuarioDAO;
import modelo.Usuario;
import icadastra.ICadastraUsuario;

public class CadastraUsuarioBD implements ICadastraUsuario {
	
	private final UsuarioDAO dao;
	
	@Inject
	public CadastraUsuarioBD (UsuarioDAO dao) {
		this.dao = dao;
	}
	/**
	* @deprecated para o CDI
	*/
	CadastraUsuarioBD() { this(null); }

	@Override
	public void cadastra(Usuario usuario) {
		this.dao.adiciona(usuario);
		
	}

	@Override
	public List<Usuario> todosOsUsuario() {
		return this.dao.todos();
	}

	@Override
	public Usuario buscaPorCPF(String cpf) {
		return this.dao.buscaPorCPF(cpf);
	}

	@Override
	public void remover(Usuario usuario) {
		this.dao.remover(usuario);	
	}
}
