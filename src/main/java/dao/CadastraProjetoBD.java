package dao;


import java.util.List;

import javax.inject.Inject;



import modelo.ICadastraProjeto;
import modelo.Projeto;


public class CadastraProjetoBD implements ICadastraProjeto {
	
	private final ProjetoDAO dao;
	
	@Inject
	public CadastraProjetoBD (ProjetoDAO dao) {
		this.dao = dao;
	}
	/**
	* @deprecated para o CDI
	*/
	CadastraProjetoBD() { this(null); }

	@Override
	public void cadastra(Projeto projeto) {
		this.dao.adiciona(projeto);
		
	}

	@Override
	public List<Projeto> todosOsProjetos() {
		return this.dao.todos();
	}

	@Override
	public Projeto buscaPorTitulo(String titulo) {
		return this.dao.buscaPorTitulo(titulo);
	}
}