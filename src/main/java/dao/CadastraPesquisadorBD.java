package dao;

import java.util.List;

import javax.inject.Inject;




import modelo.Categoria;
import modelo.Departamento;
import modelo.ICadastraPesquisador;
import modelo.Pesquisador;


public class CadastraPesquisadorBD implements ICadastraPesquisador {
	
	private final PesquisadorDAO dao;
	
	@Inject
	public CadastraPesquisadorBD (PesquisadorDAO dao) {
		this.dao = dao;
	}
	/**
	* @deprecated para o CDI
	*/
	CadastraPesquisadorBD() { this(null); }

	@Override
	public void cadastra(Pesquisador pesquisador) {
		this.dao.adiciona(pesquisador);	
	}

	@Override
	public List<Pesquisador> todosOsPesquisadores() {
		return this.dao.todos();
	}

	@Override
	public Pesquisador buscaPorCPF(String cpf) {
		return this.dao.buscaPorCPF(cpf);
	}
	@Override
	public List<Categoria> listaCategoria() {
		return this.dao.listaCategoria();
	}
	@Override
	public List<Departamento> listaDepartamento() {
		// TODO Auto-generated method stub
		return this.dao.listaDepartamento();
	}
}