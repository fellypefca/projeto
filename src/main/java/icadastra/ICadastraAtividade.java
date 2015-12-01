package icadastra;

import java.util.List;

import modelo.Atividade;

public interface ICadastraAtividade {

	void cadastra(Atividade atividade);

	List<Atividade> todasAsAtividades();

	Atividade buscaPorId(Long atividadeId);
	
	void remover(Atividade atividade);
}
