package com.antonio.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String endereco;
	
	private String CNPJ;
	
//	private Localizacao localizacao;
//	
//	private ArrayList<Recurso> recursos;
	
//	private int ocupacao;
	
	public Hospital() {}

	public Hospital(String nome, String endereco, String cNPJ, Localizacao localizacao, ArrayList<Recurso> recursos,
			int ocupacao) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		CNPJ = cNPJ;
//		this.localizacao = localizacao;
//		this.recursos = recursos;
//		this.ocupacao = ocupacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

//	public Localizacao getLocalizacao() {
//		return localizacao;
//	}
//
//	public void setLocalizacao(Localizacao localizacao) {
//		this.localizacao = localizacao;
//	}

//	public ArrayList<Recurso> getRecursos() {
//		return recursos;
//	}
//
//	public void setRecursos(ArrayList<Recurso> recursos) {
//		this.recursos = recursos;
//	}

//	public int getOcupacao() {
//		return ocupacao;
//	}
//
//	public void setOcupacao(int ocupacao) {
//		this.ocupacao = ocupacao;
//	}
	
}
