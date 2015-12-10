package controller;

import icadastra.ICadastraProjeto;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;



<<<<<<< HEAD

=======
>>>>>>> d29d6909e15becd88d936378e2b774c60b78b373
import modelo.Projeto;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class ProjetoController {

	private ICadastraProjeto aux;
	private Result result;
	private Validator validator;

	@Inject
	public ProjetoController(ICadastraProjeto aux, Result result,
			Validator validator) {
		
		this.aux = aux;
		this.result = result;
		this.validator = validator;
	}
	
	ProjetoController() {}
	public void index() {}
	public void formulario() {}

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
	
	public List<String> teste() {
		List<Projeto> listaAx = new ArrayList<Projeto>();
		listaAx = aux.todosOsProjetos();
		List<String> listaProj = new ArrayList<String>();
		for (Projeto p: listaAx){
			listaProj.add(p.getTitulo());
		}
		return listaProj;
	}
}