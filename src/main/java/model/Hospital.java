package model;

public class Hospital {
	
	private String nome;
	
	private String endereço;
	
	private String CNPJ;
	
	private Localizacao localizacao;
	
	public Hospital(String nome, String endereço, String cNPJ, Localizacao localizacao) {
		this.nome = nome;
		this.endereço = endereço;
		CNPJ = cNPJ;
		this.localizacao = localizacao;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereço() {
		return endereço;
	}


	public void setEndereço(String endereço) {
		this.endereço = endereço;
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
}
