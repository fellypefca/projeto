package controller;

import java.util.List;

import javax.inject.Inject;


import modelo.ICadastraProjeto;
import modelo.Projeto;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
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

		validator.validate(projeto);
		validator.onErrorRedirectTo(this).formulario();
		aux.cadastra(projeto);
		result.redirectTo(this).lista();
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
}