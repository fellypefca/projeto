package controller;
import icadastra.ICadastraOrgao;

import java.util.List;

import javax.inject.Inject;

import modelo.Categoria;
import modelo.Orgao;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class OrgaoController {

		private ICadastraOrgao aux;
		private Result result;
		private Validator validator;
		
		@Inject
		public OrgaoController(ICadastraOrgao aux, Result result, Validator validator) {
			
			this.aux = aux;
			this.result = result;
			this.validator = validator;
		}

		
		public OrgaoController() {}
		
		public void index() {}
		public void formulario() {}

		public void salva(Orgao orgao) throws Exception{
			
			Orgao teste = aux.buscaPorCnpj(orgao.getCnpj());
			if(teste != null)
			{
				validator.add(new I18nMessage("Erro","orgao.existente"));
				validator.onErrorRedirectTo(this).formulario();
			}
				
			else
			{
			validator.validate(orgao);
			validator.onErrorRedirectTo(this).formulario();
			aux.cadastra(orgao);
			result.redirectTo(this).lista();
		}
		}

		public List<Orgao> lista() {
			return aux.todosOsOrgaos();
		}

		public void edita(String cnpj) {
			Orgao orgaoEncontrado = aux.buscaPorCnpj(cnpj);
			if (orgaoEncontrado == null) {
				result.notFound();
			} else {
				result.include(orgaoEncontrado);
				result.of(this).formulario();
			}
		}
		public void remover(String cnpj){
			Orgao OrgaoEncontrado = aux.buscaPorCnpj(cnpj);
			if (OrgaoEncontrado == null) {
				result.notFound();
			} else {
				aux.remover(OrgaoEncontrado);
				result.redirectTo(this).lista();
			}
			
		}
}