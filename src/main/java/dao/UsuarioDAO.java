//package dao;
//
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.Query;
//
//import modelo.Usuario;
//
//import org.osgi.service.component.annotations.Component;
//
//import controller.IndexController;
//import br.com.caelum.vraptor.Result;
//
//@Component
//public class UsuarioDAO {
//    private EntityManager manager;
//    private Result result;
//
//    public UsuarioDAO(EntityManager manager, Result result) {
//        this.manager = manager;
//        this.result = result;
//    }
//
//    public Usuario carrega(Usuario usuario) {
//        try {
//            Query query = this.manager
//                    .createQuery(
//                            "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha",
//                            Usuario.class);
//            query.setParameter("login", usuario.getLogin());
//            query.setParameter("senha", usuario.getSenha());
//            return (Usuario) query.getSingleResult();
//        } catch (NoResultException e) {
//            result.include("status",
//                    "<ul class='alert alert-danger'>Usuário e/ou senha incorretos</ul>");
//            result.of(IndexController.class).index();
//            return usuario;
//        }
//    }
//
//    public boolean verificaAcesso(Usuario usuario) {
//        return true;
//    }
//
//    public void adiciona(Usuario usuario) {
//        this.manager.persist(usuario);
//    }
//}