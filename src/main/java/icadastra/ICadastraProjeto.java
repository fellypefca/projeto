package icadastra;

import java.util.List;

import modelo.Projeto;

public interface ICadastraProjeto {

	void cadastra(Projeto projeto);

	List<Projeto> todosOsProjetos();

	Projeto buscaPorTitulo(String titulo);
	
	void remover(Projeto projeto);

}
