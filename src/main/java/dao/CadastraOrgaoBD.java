package dao;

import java.util.List;

import javax.inject.Inject;

import modelo.ICadastraOrgao;
import modelo.OrgaoFinanciador;

public class CadastraOrgaoBD implements ICadastraOrgao{


	
	private final OrgaoDAO dao;
	
	@Inject
	public CadastraOrgaoBD(OrgaoDAO dao) {
		this.dao = dao;
	}
	
	/**
	* @deprecated para o CDI
	*/
	CadastraOrgaoBD() { this(null); }

	@Override
	public void cadastra(OrgaoFinanciador orgao) {
		this.dao.adiciona(orgao);
		
	}

	@Override
	public List<OrgaoFinanciador> todosOsOrgaos() {
		return this.dao.todos();
	}

	@Override
	public OrgaoFinanciador buscaPorNome(String nome) {
		return this.dao.buscaPorNome(nome);
	}
}

