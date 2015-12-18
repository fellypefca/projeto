package dao;

import java.util.List;

import modelo.Usuario;

public interface UsuarioDAO {
	
	void adiciona(Usuario usuario);

	List<Usuario> todos();

	Usuario buscaPorCPF(String cpf);
	
	void remover(Usuario usuario);
}
