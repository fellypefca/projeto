package controller;

import icadastra.ICadastraEndereço;
import icadastra.ICadastraPesquisador;

import java.util.List;

import javax.inject.Inject;

import modelo.Categoria;
import modelo.Departamento;
import modelo.Endereco;
import modelo.Pesquisador;
import modelo.Projeto;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class PesquisadorController {
	
	private ICadastraPesquisador aux;
	private ICadastraEndereço auxE;
	private Result result;
	private Validator validator;
	
	@Inject
	public PesquisadorController(ICadastraEndereço auxE, ICadastraPesquisador aux, Result result,
			Validator validator) {
		
		super();
		this.aux = aux;
		this.result = result;
		this.validator = validator;
		this.auxE = auxE;
	}
	
	public PesquisadorController() {}
	public void index() {}
	public void formulario() 
	{	
		result.include("categoria", listaCategoria());
		result.include("departamento", listaDepartamento());
	}
	
public void salva(Pesquisador pesquisador, Endereco endereco) {
		
		validator.validate(pesquisador);
		validator.onErrorRedirectTo(this).formulario();
		aux.cadastra(pesquisador);
		
		validator.validate(endereco);
		validator.onErrorRedirectTo(this).formulario();
		auxE.cadastra(endereco);
		
		pesquisador.setEndereco(endereco);
		aux.cadastra(pesquisador);
		
		result.redirectTo(this).lista();
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