package icadastra;

import java.util.List;

import modelo.Departamento;

public interface ICadastraDepartameno {

	void cadastra(Departamento departemtno);

	List<Departamento> todosOsDepartamentos();

	Departamento buscaPorSigla(String nome);
	
	void remover(Departamento departamento);
}
