package modelo;

import java.util.List;

public interface ICadastraOrgao {

	void cadastra(OrgaoFinanciador orgao);

	List<OrgaoFinanciador> todosOsOrgaos();

	OrgaoFinanciador buscaPorNome(String nome);

}
