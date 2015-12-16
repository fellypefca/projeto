package controller;

import icadastra.ICadastraOrgao;
import icadastra.ICadastraPesquisador;
import icadastra.ICadastraProjeto;

import java.util.List;

import javax.inject.Inject;








import modelo.Categoria;
import modelo.Orgao;
import modelo.Pesquisador;
import modelo.Projeto;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class ProjetoController {

	private ICadastraProjeto aux;
	private ICadastraOrgao auxOrg;
	private ICadastraPesquisador auxPes;
	private Result result;
	private Validator validator;

	@Inject
	public ProjetoController(ICadastraProjeto aux, ICadastraOrgao auxOrg, ICadastraPesquisador auxPes, Result result,
			Validator validator) {
		
		this.aux = aux;
		this.result = result;
		this.validator = validator;
		this.auxOrg = auxOrg;
		this.auxPes = auxPes;
	}
	
	ProjetoController() {}
	public void index() {}
	public void formulario() {
		result.include("orgao", listaOrgao());
		result.include("pesquisador", listaPes());
	}

	public void salva(Projeto projeto) {
		
//		Projeto teste = aux.buscaPorTitulo(projeto.getTitulo());
//		if(teste != null)
//		{
//			validator.add(new I18nMessage("Erro","projeto.existente"));
//			validator.onErrorRedirectTo(this).formulario();
//		}
//			
//		else
//		{

		validator.validate(projeto);
		validator.onErrorRedirectTo(this).formulario();
		aux.cadastra(projeto);
		result.redirectTo(this).lista();
//	}
	}

	public List<Projeto> lista() {
		return aux.todosOsProjetos();
	}

	public void edita(String titulo) {
		Projeto projetoEncontrado = aux.buscaPorTitulo(titulo);
		if (projetoEncontrado == null) {
			result.notFound();
		} else {
			result.include(projetoEncontrado);
			result.of(this).formulario();
		}
	}
	public void remover(String titulo){
		Projeto projetoEncontrado = aux.buscaPorTitulo(titulo);
		if (projetoEncontrado == null) {
			result.notFound();
		} else {
			aux.remover(projetoEncontrado);
			result.redirectTo(this).lista();
		}
		
	}
	
	public List<Orgao> listaOrgao() 
	{
		return auxOrg.todosOsOrgaos();
	}
	
	public List<Pesquisador> listaPes() 
	{
		return auxPes.todosOsPesquisadores();
	}
	
	public void lista2() {
		
	}
}