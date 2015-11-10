package modelo;


import java.util.Calendar;





import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Projeto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotEmpty @Column(unique = true)
	private String titulo;

	private String descricao;
	
	private String palavrasChave;

	private Calendar dataInicio;
	
	private Calendar dataFim;
	
	@NotEmpty 
	private String nomeDoCoordenador;
	
	@ManyToMany
    @JoinTable(name="Projeto_has_Orgaos", joinColumns={@JoinColumn(name="projeto_id")}, inverseJoinColumns={@JoinColumn(name="orgao_id")})
	private List<Orgao> orgao;
	
	
//	@ManyToMany
//    @JoinTable(name="Projeto_has_Pesquisadores", joinColumns={@JoinColumn(name="projeto_id")}, inverseJoinColumns={@JoinColumn(name="pesquisador_id")})
//	private List<Pesquisador> pesquisadores;
	
	public Projeto() {}
	
	public Projeto (String titulo, String descricao, 
			String palavrasChave, Calendar dataInicio, 
			Calendar dataFim, String nomeDoCoordenador, List<Orgao> orgao) {
		
		this.titulo = titulo;
		this.descricao = descricao;
		this.palavrasChave = palavrasChave;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.nomeDoCoordenador = nomeDoCoordenador;
		this.orgao = orgao;
//		this.pesquisadores = pesquisadores;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPalavrasChave() {
		return palavrasChave;
	}
	public void setPalavrasChave(String palavrasChave) {
		this.palavrasChave = palavrasChave;
	}
	public Calendar getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Calendar getDataFim() {
		return dataFim;
	}
	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	public String getNomeDoCoordenador() {
		return nomeDoCoordenador;
	}
	public void setNomeDoCoordenador(String nomeDoCoordenador) {
		this.nomeDoCoordenador = nomeDoCoordenador;
	}
	
	public List<Orgao> getOrgao() {
		return orgao;
	}
	
	public void setOrgao(List<Orgao> orgao) {
		this.orgao = orgao;
	}
	
//	public List<Pesquisador> getPesquisadoresLista() {
//		return pesquisadores;
//	}
//	
//	public void setPesquisadoresLista(List<Pesquisador> pesquisadores) {
//		this.pesquisadores = pesquisadores;
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}