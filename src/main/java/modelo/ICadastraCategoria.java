package modelo;

import java.util.List;

public interface ICadastraCategoria {

	void cadastra(Categoria categoria);

	List<Categoria> todosAsCategorias();

	Categoria buscaPorNome(String categoria);

}
