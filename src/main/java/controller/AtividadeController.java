package controller;

import icadastra.ICadastraAtividade;

import java.util.List;

import javax.inject.Inject;

import com.sun.imageio.plugins.common.I18N;

import modelo.Atividade;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class AtividadeController {
	
	private ICadastraAtividade aux;
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
	
	public void formulario() {}

	public void salva(Atividade atividade) throws Exception{
		
		Atividade teste = aux.buscaPorId(atividade.getId());
		
		if(teste == null || (!teste.equals(atividade))){
			validator.validate(atividade);
			validator.onErrorRedirectTo(this).formulario();
			aux.cadastra(atividade);
			result.redirectTo(this).lista();
		}
		else
		{
			validator.add(new I18nMessage("Erro","Atividade.existente"));
			validator.onErrorRedirectTo(this).formulario();
		}
			
	}

	public List<Atividade> lista() {
		return aux.todasAsAtividades();
	}

	public void edita(Long id) {
		Atividade AtividadeEncontrado = aux.buscaPorId(id);
		if (AtividadeEncontrado == null) {
			result.notFound();
		} else {
			result.include(AtividadeEncontrado);

			result.of(this).formulario();
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