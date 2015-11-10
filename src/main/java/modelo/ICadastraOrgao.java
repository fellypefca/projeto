package modelo;

import java.util.List;

public interface ICadastraOrgao {

	void cadastra(Orgao orgao);

	List<Orgao> todosOsOrgaos();

	Orgao buscaPorCnpj(String cnpj);

}
