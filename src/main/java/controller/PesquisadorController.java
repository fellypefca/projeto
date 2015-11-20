package controller;

import icadastra.ICadastraPesquisador;

import java.util.List;

import javax.inject.Inject;

import modelo.Categoria;
import modelo.Departamento;
import modelo.Pesquisador;
import modelo.Projeto;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class PesquisadorController {
	
	private ICadastraPesquisador aux;
	private Result result;
	private Validator validator;
	
	@Inject
	public PesquisadorController(ICadastraPesquisador aux, Result result,
			Validator validator) {
		
		super();
		this.aux = aux;
		this.result = result;
		this.validator = validator;
	}
	
	public PesquisadorController() {}
	public void index() {}
	public void formulario() 
	{	
		result.include("categoria", listaCategoria());
		result.include("departamento", listaDepartamento());
	}
	
	public void salva(Pesquisador pesquisador) {
		
//		Pesquisador teste = aux.buscaPorCPF(pesquisador.getCpf());
//		if(teste != null) {
//			validator.add(new I18nMessage("Erro","pesquisador.existente"));
//			validator.onErrorRedirectTo(this).formulario();
//		}
//		else {
		validator.validate(pesquisador);
		validator.onErrorRedirectTo(this).formulario();
		aux.cadastra(pesquisador);
		result.redirectTo(this).lista();
//		}
	}

	public List<Pesquisador> lista() {
		return aux.todosOsPesquisadores();
	}

	public void edita(String cpf) {
		Pesquisador pesquisadorEncontrado = aux.buscaPorCPF(cpf);
		if (pesquisadorEncontrado == null) {
			result.notFound();
		} else 
		{
			result.include("categoria", listaCategoria());
			result.include("departamento", listaDepartamento());
			
			result.include(pesquisadorEncontrado);

			result.of(this).formulario();
		}
	}	
	
	public List<Categoria> listaCategoria()
	{
		return aux.listaCategoria();
	}
	
	public List<Departamento> listaDepartamento()
	{
		return aux.listaDepartamento();
	}
	public void remover(String cpf){
		Pesquisador pesquisadorEncontrado = aux.buscaPorCPF(cpf);
		if (pesquisadorEncontrado == null) {
			result.notFound();
		} else {
			aux.remover(pesquisadorEncontrado);
			result.redirectTo(this).lista();
		}
		
	}
}