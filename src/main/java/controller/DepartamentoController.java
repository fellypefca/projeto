package controller;

import java.util.List;

import javax.inject.Inject;

import modelo.Departamento;
import modelo.ICadastraDepartameno;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class DepartamentoController {
	
	private ICadastraDepartameno aux;
	private Result result;
	private Validator validator;
	
	@Inject
	public DepartamentoController(ICadastraDepartameno aux, Result result, Validator validator) {
		
		this.aux = aux;
		this.result = result;
		this.validator = validator;
	}

	
	public DepartamentoController() {}
	public void index() {}
	public void formulario() {}

	public void salva(Departamento departamento) throws Exception {

		Departamento dep = this.aux.buscaPorSigla(departamento.getSigla());
		if(dep != null)
		{
			validator.add(new I18nMessage("Departamento", "departamento.cadastrado"));
			validator.onErrorRedirectTo(this).formulario();
		}
		else
		{
			validator.validate(departamento);
			validator.onErrorRedirectTo(this).formulario();
			aux.cadastra(departamento);
			result.redirectTo(this).lista();
		}
	}

	public List<Departamento> lista() {
		return aux.todosOsDepartamentos();
	}

	public void edita(String sigla) {
		Departamento departamentoEncontrado = aux.buscaPorSigla(sigla);
		if (departamentoEncontrado == null) {
			result.notFound();
		} else {
			result.include(departamentoEncontrado);
			result.of(this).formulario();
		}
	}
}