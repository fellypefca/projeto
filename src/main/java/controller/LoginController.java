package controller;

import javax.inject.Inject;

//import icadastra.RegistroDeUsuarios;
//import modelo.Usuario;
//import modelo.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {

//	private RegistroDeUsuarios usuarios;
//	private UsuarioLogado logado;
	private Result result;
	private Validator validator;

	@Inject
	public LoginController(
			Result result, Validator validator) {
//		this.usuarios = usuarios;
//		this.logado = logado;
		this.result = result;
		this.validator = validator;
	}

	@Deprecated
	LoginController() {
	}

	
	public void formulario() {
	}


	public void login() {
//		Usuario usuario = usuarios.comLoginESenha(login, senha);
//		validator.ensure(usuario != null, new I18nMessage("usuario",
//				"login.ou.senha.invalidos"));
//		validator.onErrorRedirectTo(this).formulario();
//		logado.loga(usuario);
//		// ou a página inicial
		result.redirectTo(IndexController.class).index();
	}

//	@Get("/logout")
////	public void logout() {
////		logado.desloga();
////		result.redirectTo(this).formulario();
//	}
}
