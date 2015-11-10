package modelo;

import java.util.List;

public interface ICadastraProjeto {

	void cadastra(Projeto projeto);

	List<Projeto> todosOsProjetos();

	Projeto buscaPorTitulo(String titulo);

}
