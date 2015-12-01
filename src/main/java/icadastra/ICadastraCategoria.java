package icadastra;

import java.util.List;

import modelo.Categoria;

public interface ICadastraCategoria {

	void cadastra(Categoria categoria);

	List<Categoria> todosAsCategorias();

	Categoria buscaPorNome(String categoria)
	;
	void remover(Categoria categoria);
}
