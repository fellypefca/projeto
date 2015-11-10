package modelo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Pesquisador {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long Id;	
	
	@NotEmpty @Column(unique = true)
	private String cpf;
	
	@NotEmpty
	private String nome;

	private String telefone;

	private String email;
	
	private Calendar nascimento;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DEPARTAMENTO_ID", nullable = true)
	private Departamento departamento;
	

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CATEGORIA_ID", nullable = true)
	private Categoria categoria;
	
//	@JoinColumn
//	private Endereco endereco;

	private String lattesUrl;
	
	public Pesquisador(String cpf, String nome, String telefone,
			String email, Calendar nascimento, Departamento departamento,
			Categoria categoria, String lattesUrl) {
		
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.nascimento = nascimento;
		this.departamento = departamento;
		this.categoria = categoria;
		this.lattesUrl = lattesUrl;
	}
	
	public Pesquisador()
	{
		
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
//	public Endereco getEndereco() {
//		return endereco;
//	}
//	public void setEndereco(Endereco endereco) {
//		this.endereco = endereco;
//	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getLattesUrl() {
		return lattesUrl;
	}
	public void setLattesUrl(String lattesUrl) {
		this.lattesUrl = lattesUrl;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pesquisador other = (Pesquisador) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
}
