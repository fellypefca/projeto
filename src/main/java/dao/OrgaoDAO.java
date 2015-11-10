package dao;

import java.util.List;

import modelo.Orgao;

public interface OrgaoDAO {
	void adiciona(Orgao orgao);

	List<Orgao> todos();

	Orgao buscaPorCnpj(String cnpj);
}
