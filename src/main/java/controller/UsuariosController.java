//package controller;
//
//import javax.servlet.jsp.tagext.ValidationMessage;
//
//import modelo.Usuarios;
//import br.com.caelum.vraptor.Controller;
//import br.com.caelum.vraptor.Result;
//import br.com.caelum.vraptor.validator.Validator;
//
//@Controller
//public class UsuariosController {
//	
//	private final UsuarioDao dao;
//	  private final Result result;
//	  private final Validator validator;
//
//	  public UsuariosController(UsuarioDao dao, Result result, 
//	        Validator validator) {
//	    this.dao = dao;
//	    this.result = result;S
//	    this.validator = validator;
//	  }
//	  @Post("/usuarios")
//	  public void adiciona(Usuarios usuario) {
//	    if (dao.existeUsuario(usuario)) {
//	      validator.add(new ValidationMessage("Login já existe", 
//	          "usuario.login"));
//	    }
//	    validator.onErrorUsePageOf(UsuariosController.class).novo();
//
//	    dao.adiciona(usuario);
//
//	    result.redirectTo(PController.class).lista();
//	  }
//	
//	public void novo() {
//		
//	}
//
//}
