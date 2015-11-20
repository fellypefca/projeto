package icadastra;

import java.util.List;

import modelo.Categoria;
import modelo.Departamento;
import modelo.Pesquisador;

public interface ICadastraPesquisador {
	
	void cadastra(Pesquisador pesquisador);
	List<Pesquisador> todosOsPesquisadores();
	Pesquisador buscaPorCPF(String cpf);
	List<Categoria> listaCategoria();
	List<Departamento> listaDepartamento();
	void remover(Pesquisador pesquisador);
}
