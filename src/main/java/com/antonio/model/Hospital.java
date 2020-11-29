package com.antonio.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.antonio.model.recurso.Recurso;

/**Classe para objetos do tipo Hospital, onde serão contidos, atributos do mesmo.
 * 
 * @author anton
 *
 */
@Entity
public class Hospital {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;
	
	@NotNull
	@Column(unique=true)
	private String CNPJ;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Localizacao localizacao;
	
	@OneToMany(cascade= CascadeType.REFRESH)
	private List<Recurso> recursos;
	
	@NotNull
	private int indiceOcupacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaAtualizacao;
	
	public Hospital() {}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public int getIndiceOcupacao() {
		return indiceOcupacao;
	}

	public void setIndiceOcupacao(int indiceOcupacao) {
		this.indiceOcupacao = indiceOcupacao;
	}


	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}


	public void setUltimaAtualizacao(Date ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}
	
}
