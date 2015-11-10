package dao;

import java.util.List;

import modelo.Categoria;
import modelo.Departamento;
import modelo.Pesquisador;

public interface PesquisadorDAO {
	
	void adiciona(Pesquisador pesquisador);
	List<Pesquisador> todos();
	Pesquisador buscaPorCPF(String cpf);
	List<Categoria> listaCategoria();
	List<Departamento> listaDepartamento();

}
