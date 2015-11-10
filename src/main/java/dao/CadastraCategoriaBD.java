package dao;


import java.util.List;

import javax.inject.Inject;
import modelo.Categoria;
import modelo.ICadastraCategoria;



public class CadastraCategoriaBD implements ICadastraCategoria {
	
	private final CategoriaDAO dao;
	
	@Inject
	public CadastraCategoriaBD (CategoriaDAO dao) {
		this.dao = dao;
	}
	/**
	* @deprecated para o CDI
	*/
	CadastraCategoriaBD() { this(null); }

	@Override
	public void cadastra(Categoria categoria) {
		this.dao.adiciona(categoria);
		
	}

	@Override
	public List<Categoria> todosAsCategorias() {
		return this.dao.todos();
	}

	@Override
	public Categoria buscaPorNome(String categoria) {
		return this.dao.buscaPorCategoria(categoria);
	}
}