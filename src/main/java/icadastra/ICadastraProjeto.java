package icadastra;

import java.util.List;

import modelo.Atividade;
import modelo.Orgao;
import modelo.Projeto;

public interface ICadastraProjeto {

	void cadastra(Projeto projeto);

	List<Projeto> todosOsProjetos();

	Projeto buscaPorTitulo(String titulo);
	
	List<Atividade> todasAsAtividades(String titulo);
	
	void remover(Projeto projeto);
	

}
