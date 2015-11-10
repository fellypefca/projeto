package dao;

import java.util.List;

import modelo.Projeto;

public interface ProjetoDAO {
	
	void adiciona(Projeto projeto);

	List<Projeto> todos();

	Projeto buscaPorTitulo(String titulo);
}
