//package interceptors;
//
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//
//import br.com.caelum.vraptor.AroundCall;
//import br.com.caelum.vraptor.Intercepts;
//import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
//
//@Intercepts
//public class TransacoesInterceptor {
//
//	private EntityManager manager;
//
//	@Inject
//	public TransacoesInterceptor(EntityManager manager) {
//		this.manager = manager;
//	}
//
//	@Deprecated
//	TransacoesInterceptor() {
//	}
//
//	@AroundCall
//	public void trataTransacao(SimpleInterceptorStack stack) {
//		try {
//			manager.getTransaction().begin();
//			stack.next();
//			manager.getTransaction().commit();
//		} finally {
//			if (manager.getTransaction().isActive()) {
//				manager.getTransaction().rollback();
//			}
//		}
//	}
//
//}
