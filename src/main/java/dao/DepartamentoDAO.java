package dao;

import java.util.List;

import modelo.Departamento;

public interface DepartamentoDAO {

	void adiciona(Departamento departamento);

	List<Departamento> todos();

	Departamento buscaPorSigla(String nome);
}
