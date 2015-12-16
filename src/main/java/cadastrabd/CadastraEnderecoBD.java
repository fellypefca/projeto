package cadastrabd;

import java.util.List;

import javax.inject.Inject;

import dao.EnderecoDAO;
import modelo.Endereco;
import icadastra.ICadastraEndereço;

public class CadastraEnderecoBD implements ICadastraEndereço {
	
	private final EnderecoDAO dao;
	
	@Inject
	public CadastraEnderecoBD (EnderecoDAO dao) {
		this.dao = dao;
	}
	
	/**
	* @deprecated para o CDI
	*/
	
	CadastraEnderecoBD() { this(null); }

	@Override
	public void cadastra(Endereco endereco) {
		this.dao.adiciona(endereco);
	}

	@Override
	public List<Endereco> todosOsEnderecos() {
		return this.dao.todos();
	}

	@Override
	public Endereco buscaPorId(Long id) {
		return this.dao.buscaPorEndereco(id);
	}

	@Override
	public void remover(Endereco endereco) {
		this.dao.remover(endereco);
	}

}
