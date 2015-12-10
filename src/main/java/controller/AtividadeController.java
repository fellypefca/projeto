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
	private ICadastraProjeto auxProj;
	private Result result;
	private Validator validator;
	
	@Inject
	public AtividadeController(ICadastraAtividade aux, Result result, Validator validator, ICadastraProjeto auxProj) {
		this.auxProj = auxProj;
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
			
			String titulo = atividade.getTituloProj();
			Projeto tempProj = auxProj.buscaPorTitulo(titulo);
			if (tempProj == null){
<<<<<<< HEAD
				aux.remover(atividade);
=======
>>>>>>> d29d6909e15becd88d936378e2b774c60b78b373
				result.redirectTo(this).index();
			}
			tempProj.addAtividade(atividade);
			auxProj.cadastra(tempProj);
			aux.cadastra(atividade);
<<<<<<< HEAD
			result.redirectTo(this).lista();
=======
			result.redirectTo(this).listaProj(atividade.getTituloProj());
>>>>>>> d29d6909e15becd88d936378e2b774c60b78b373
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
	
	public List<Atividade> listaProj(String titulo) {
		Projeto projeto = auxProj.buscaPorTitulo(titulo);
		result.include(projeto);
		return auxProj.todasAsAtividades(titulo);
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