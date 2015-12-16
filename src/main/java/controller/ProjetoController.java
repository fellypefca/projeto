package controller;

import icadastra.ICadastraOrgao;
import icadastra.ICadastraPesquisador;
import icadastra.ICadastraProjeto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
		
		String[] tmp = projeto.getCnpjs().split(Pattern.quote(", "));
		List<Orgao> orgaos = new ArrayList<Orgao>(); 
		for(String cnpj: tmp){
			System.out.println(cnpj);
			Orgao o = auxOrg.buscaPorCnpj(cnpj);
			orgaos.add(o);
		}
		String[] pes = projeto.getPesquisadores().split(Pattern.quote(", "));
		List<Pesquisador> pesquisadores = new ArrayList<Pesquisador>();
		for(String cpf: pes){
			System.out.println(cpf);
			Pesquisador p = auxPes.buscaPorCPF(cpf);
			pesquisadores.add(p);
		}
		
		projeto.setPesquisadoresLista(pesquisadores);
		projeto.setOrgao(orgaos);
		
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