package cadastrabd;

import icadastra.ICadastraOrgao;

import java.util.List;

import javax.inject.Inject;

import dao.OrgaoDAO;
import modelo.Orgao;

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
	public void cadastra(Orgao orgao) {
		this.dao.adiciona(orgao);
		
	}

	@Override
	public List<Orgao> todosOsOrgaos() {
		return this.dao.todos();
	}

	@Override
	public Orgao buscaPorCnpj(String cnpj) {
		return this.dao.buscaPorCnpj(cnpj);
	}

	@Override
	public void remover(Orgao orgao) {
		this.dao.remover(orgao);
		
	}
}

