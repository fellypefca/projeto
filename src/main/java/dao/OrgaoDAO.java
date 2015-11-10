package dao;

import java.util.List;

import modelo.OrgaoFinanciador;

public interface OrgaoDAO {
	void adiciona(OrgaoFinanciador orgao);

	List<OrgaoFinanciador> todos();

	OrgaoFinanciador buscaPorNome(String nome);
}
