package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Orgao {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty @Column(unique = true)
	private String cnpj;
	
	public Orgao(){}
	
	public Orgao(String nome, String cnpj){
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}
	public Long getId() {
		return id;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: "+getId()+" / "+getCnpj()+" - "+getNome();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Orgao other = (Orgao) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
}