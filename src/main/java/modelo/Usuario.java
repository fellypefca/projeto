//package modelo;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//
//@Entity
//public class Usuario {
//	
//	@Id
//	@SequenceGenerator(name = "seq", sequenceName = "visits_seq")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
//	private Long id;
//	
//	private String login;
//	private String senha;
//	private boolean admin;
//	
//	public Long getId() {
//		return id;
//	}
//
//	public String getLogin() {
//		return login;
//	}
//
//	public void setLogin(String login) {
//		this.login = login;
//	}
//
//	public String getSenha() {
//		return senha;
//	}
//
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
//
//	public boolean isAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(boolean admin) {
//		this.admin = admin;
//	}
//}
