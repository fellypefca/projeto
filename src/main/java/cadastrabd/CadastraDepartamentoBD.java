package cadastrabd;

import icadastra.ICadastraDepartameno;

import java.util.List;

import javax.inject.Inject;

import dao.DepartamentoDAO;
import modelo.Departamento;

public class CadastraDepartamentoBD implements ICadastraDepartameno {
	
	private final DepartamentoDAO dao;
	
	@Inject
	public CadastraDepartamentoBD(DepartamentoDAO dao) {
		this.dao = dao;
	}
	
	/**
	* @deprecated para o CDI
	*/
	CadastraDepartamentoBD() { this(null); }

	@Override
	public void cadastra(Departamento departemtno) {
		this.dao.adiciona(departemtno);
		
	}

	@Override
	public List<Departamento> todosOsDepartamentos() {
		return this.dao.todos();
	}

	@Override
	public Departamento buscaPorSigla(String nome) {
		return this.dao.buscaPorSigla(nome);
	}

	@Override
	public void remover(Departamento departamento) {
		this.dao.remover(departamento);
		
	}
}
