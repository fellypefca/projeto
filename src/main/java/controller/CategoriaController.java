package controller;

import java.util.List;

import javax.inject.Inject;

import com.sun.imageio.plugins.common.I18N;

import modelo.Categoria;
import modelo.ICadastraCategoria;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class CategoriaController {
	
	private ICadastraCategoria aux;
	private Result result;
	private Validator validator;
	
	@Inject
	public CategoriaController(ICadastraCategoria aux, Result result, Validator validator) {
		
		this.aux = aux;
		this.result = result;
		this.validator = validator;
	}

	
	CategoriaController() {}
	
	public void index() {}
	
	public void formulario() {}

	public void salva(Categoria categoria) throws Exception{
		
		Categoria teste = aux.buscaPorNome(categoria.getTipo());
		if(teste != null)
		{
			validator.add(new I18nMessage("Cadastro","campo.existente"));
			validator.onErrorRedirectTo(this).formulario();
		}
			
		else
		{
			validator.validate(categoria);
			validator.onErrorRedirectTo(this).formulario();
			aux.cadastra(categoria);
			result.redirectTo(this).lista();
		}
	}

	public List<Categoria> lista() {
		return aux.todosAsCategorias();
	}

	public void edita(String tipo) {
		Categoria categoriaEncontrado = aux.buscaPorNome(tipo);
		if (categoriaEncontrado == null) {
			result.notFound();
		} else {
			result.include(categoriaEncontrado);

			result.of(this).formulario();
		}
	}
}