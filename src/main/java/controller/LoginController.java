package controller;

import icadastra.ICadastraUsuario;

import javax.inject.Inject;





import modelo.Orgao;
import modelo.Usuario;
import modelo.UsuarioLogado;
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

	private ICadastraUsuario aux;
	private UsuarioLogado logado;
	private Result result;
	private Validator validator;

	@Inject
	public LoginController(ICadastraUsuario aux,  UsuarioLogado logado,
			Result result, Validator validator) {
		
		this.aux = aux;
		this.logado = logado;
		this.result = result;
		this.validator = validator;
	}

	@Deprecated
	LoginController() {
	}

	
	public void formulario() {
	}

	public void registro() {
	}
	
	public void salva(Usuario usuario){
		Usuario teste = aux.buscaPorCPF(usuario.getCpf());
		if(teste != null)
		{
			validator.add(new I18nMessage("Erro","usuario.existente"));
			validator.onErrorRedirectTo(this).registro();
		}
			
		else
		{
		validator.validate(usuario);
		validator.onErrorRedirectTo(this).registro();
		aux.cadastra(usuario);
		result.redirectTo(this).formulario();
	}
		result.redirectTo(LoginController.class).formulario();	
	}

	public void login(String login, String senha) {
		Usuario userTmp = aux.buscaPorCPF(login);
		validator.ensure(((userTmp != null)&&(userTmp.getSenha().equals(senha))), new I18nMessage("usuario",
				"login.ou.senha.invalidos"));
		validator.onErrorRedirectTo(this).formulario();
		logado.loga(userTmp);
		// ou a página inicial
		result.redirectTo(IndexController.class).index();
	}

	@Get("/logout")
	public void logout() {
		logado.desloga();
		result.redirectTo(this).formulario();
	}
}
