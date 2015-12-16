package icadastra;

import java.util.List;

import modelo.Endereco;


public interface ICadastraEndereço {
	
	void cadastra(Endereco endereco);
	List<Endereco> todosOsEnderecos();
	Endereco buscaPorId(Long id);
	void remover(Endereco endereco);

}
