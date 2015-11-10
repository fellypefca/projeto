package controller;
import java.util.List;

import javax.inject.Inject;
import modelo.ICadastraOrgao;
import modelo.OrgaoFinanciador;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
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

		public void salva(OrgaoFinanciador orgaoFinanciador) {

			validator.validate(orgaoFinanciador);
			validator.onErrorRedirectTo(this).formulario();
			aux.cadastra(orgaoFinanciador);
			result.redirectTo(this).lista();
		}

		public List<OrgaoFinanciador> lista() {
			return aux.todosOsOrgaos();
		}

		public void edita(String nome) {
			OrgaoFinanciador orgaoEncontrado = aux.buscaPorNome(nome);
			if (orgaoEncontrado == null) {
				result.notFound();
			} else {
				result.include(orgaoEncontrado);
				result.of(this).formulario();
			}
		}
}