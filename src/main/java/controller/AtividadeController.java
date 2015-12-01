package controller;

import icadastra.ICadastraAtividade;
import icadastra.ICadastraProjeto;

import java.util.List;

import javax.inject.Inject;

import com.sun.imageio.plugins.common.I18N;

import modelo.Atividade;
import modelo.Projeto;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class AtividadeController {
	
	private ICadastraAtividade aux;
	private ICadastraProjeto projaux;
	private Result result;
	private Validator validator;
	
	@Inject
	public AtividadeController(ICadastraAtividade aux, Result result, Validator validator) {
		
		this.aux = aux;
		this.result = result;
		this.validator = validator;
	}

	
	AtividadeController() {}
	
	public void index() {}
	
	public void formulario(String titulo) {}

	public void salva(Atividade atividade, String titulo) throws Exception{
		
		Atividade teste = aux.buscaPorId(atividade.getId());
		
		if(teste == null || (!teste.equals(atividade))){
			
			Projeto projetoEncontrado = projaux.buscaPorTitulo(titulo);
			
			validator.validate(atividade);
			validator.onErrorRedirectTo(this).formulario(titulo);
			
			projetoEncontrado.addAtividade(atividade);
			aux.cadastra(atividade);
			projaux.cadastra(projetoEncontrado);
			
			result.redirectTo(this).lista();
		}
		else
		{
			validator.add(new I18nMessage("Erro","Atividade.existente"));
			validator.onErrorRedirectTo(this).formulario(titulo);
		}
			
	}

	public List<Atividade> lista() {
		return aux.todasAsAtividades();
	}

	public void edita(Long id,String titulo) {
		Atividade AtividadeEncontrado = aux.buscaPorId(id);
		if (AtividadeEncontrado == null) {
			result.notFound();
		} else {
			result.include(AtividadeEncontrado);

			result.of(this).formulario(titulo);
		}
	}
	public void remover(Long id){
		Atividade AtividadeEncontrado = aux.buscaPorId(id);
		if (AtividadeEncontrado == null) {
			result.notFound();
		} else {
			result.include(AtividadeEncontrado);

			aux.remover(AtividadeEncontrado);
			result.redirectTo(this).lista();
		}
		
	}
}