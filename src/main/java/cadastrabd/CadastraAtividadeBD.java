package cadastrabd;


import icadastra.ICadastraAtividade;

import java.util.List;

import javax.inject.Inject;

import dao.AtividadeDAO;
import modelo.Atividade;



public class CadastraAtividadeBD implements ICadastraAtividade {
	
	private final AtividadeDAO dao;
	
	@Inject
	public CadastraAtividadeBD (AtividadeDAO dao) {
		this.dao = dao;
	}
	/**
	* @deprecated para o CDI
	*/
	CadastraAtividadeBD() { this(null); }

	@Override
	public void cadastra(Atividade Atividade) {
		this.dao.adiciona(Atividade);
		
	}

	@Override
	public List<Atividade> todasAsAtividades() {
		return this.dao.todos();
	}

	@Override
	public void remover(Atividade Atividade) {
		this.dao.remover(Atividade);
		
	}
	@Override
	public Atividade buscaPorId(Long atividadeId) {
		return this.dao.buscaPorId(atividadeId);
	}
}