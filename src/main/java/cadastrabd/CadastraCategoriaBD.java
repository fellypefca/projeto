package cadastrabd;


import icadastra.ICadastraCategoria;

import java.util.List;

import javax.inject.Inject;

import dao.CategoriaDAO;
import modelo.Categoria;



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
	@Override
	public void remover(Categoria categoria) {
		this.dao.remover(categoria);
		
	}
}