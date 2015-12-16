package dao;

import java.util.List;

import modelo.Endereco;

public interface EnderecoDAO {
	
	void adiciona(Endereco endereco);

	List<Endereco> todos();

	Endereco buscaPorEndereco(Long id);
	
	void remover(Endereco endereco);

}
