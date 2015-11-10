package dao;

import java.util.List;

import modelo.Categoria;

public interface CategoriaDAO {
	
	void adiciona(Categoria categoria);

	List<Categoria> todos();

	Categoria buscaPorCategoria(String titulo);
}
