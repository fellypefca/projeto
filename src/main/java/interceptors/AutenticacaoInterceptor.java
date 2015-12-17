//package interceptors;
//
//import javax.inject.Inject;
//
//import controller.LoginController;
//import modelo.UsuarioLogado;
//import br.com.caelum.vraptor.Accepts;
//import br.com.caelum.vraptor.AroundCall;
//import br.com.caelum.vraptor.Intercepts;
//import br.com.caelum.vraptor.Result;
//import br.com.caelum.vraptor.controller.ControllerMethod;
//import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
//import br.com.caelum.vraptor.view.Results;
//
//@Intercepts
//public class AutenticacaoInterceptor {
//
//	private UsuarioLogado usuario;
//	private Result result;
//
//	@Inject
//	public AutenticacaoInterceptor(UsuarioLogado usuario, Result result) {
//		this.usuario = usuario;
//		this.result = result;
//	}
//
//	@Deprecated
//	AutenticacaoInterceptor() {
//	}
//
//	@AroundCall
//	public void autentica(SimpleInterceptorStack stack) {
//		if (usuario.isLogado()) {
//			stack.next();
//		} else {
//			result.redirectTo(LoginController.class).formulario();
//		}
//	}
//
//	@Accepts
//	public boolean ehRestrito(ControllerMethod method) {
//		return !method.getController().getType().equals(LoginController.class);
//	}
//
//	@AroundCall
//	public void autoriza(SimpleInterceptorStack stack, ControllerMethod method) {
//		if (podeAcessar(method)) {
//			stack.next();
//		} else {
//			result.use(Results.http()).sendError(401,
//					"Você não está autorizado!");
//		}
//	}
//
//	private boolean podeAcessar(ControllerMethod method) {
//		return usuario.getUsuario().isAdmin();
//	}
//}