package modelo;

import java.util.List;

public interface ICadastraDepartameno {

	void cadastra(Departamento departemtno);

	List<Departamento> todosOsDepartamentos();

	Departamento buscaPorSigla(String nome);
}
