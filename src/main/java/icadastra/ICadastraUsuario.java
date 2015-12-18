package icadastra;

import java.util.List;

import modelo.Usuario;

public interface ICadastraUsuario {
	
	void cadastra(Usuario usuario);
	List<Usuario> todosOsUsuario();
	Usuario buscaPorCPF(String cpf);
	void remover(Usuario usuario);

}
