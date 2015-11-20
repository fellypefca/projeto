package dao;

import java.util.List;

import modelo.Atividade;

public interface AtividadeDAO {
	
	void adiciona(Atividade atividade);

	List<Atividade> todos();

	Atividade buscaPorId(Long Id);
	
	void remover(Atividade atividade);
}
