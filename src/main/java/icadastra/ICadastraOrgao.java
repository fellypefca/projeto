package icadastra;

import java.util.List;

import modelo.Orgao;

public interface ICadastraOrgao {

	void cadastra(Orgao orgao);

	List<Orgao> todosOsOrgaos();

	Orgao buscaPorCnpj(String cnpj);
	
	void remover(Orgao orgao);

}
