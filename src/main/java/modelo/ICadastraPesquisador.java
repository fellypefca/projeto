package modelo;

import java.util.List;

public interface ICadastraPesquisador {
	
	void cadastra(Pesquisador pesquisador);
	List<Pesquisador> todosOsPesquisadores();
	Pesquisador buscaPorCPF(String cpf);
	List<Categoria> listaCategoria();
	List<Departamento> listaDepartamento();
}
