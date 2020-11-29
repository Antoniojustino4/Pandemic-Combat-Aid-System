package com.antonio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**Classe para objetos do tipo Paciente, onde serão contidos, atributos do mesmo.
 * 
 * @author anton
 *
 */
@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String SUS;
	
	private String CPF;
	
	@ManyToOne
	private Hospital hospital;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSUS() {
		return SUS;
	}

	public void setSUS(String sUS) {
		SUS = sUS;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	} 
	
}
