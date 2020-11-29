package com.antonio.model.recurso;

/**Classe para objetos Pontos, onde serão contidos os pontos de cada recurso.
 * 
 * @author anton
 *
 */
public class Pontos {

	private final int medico = 3;
	
	private final int enfermeiro = 3;
	
	private final int respirador = 5;
	
	private final int tomografo = 12;
	
	private final int ambulancia = 10;

	public int getMedico() {
		return medico;
	}

	public int getEnfermeiro() {
		return enfermeiro;
	}

	public int getRespirador() {
		return respirador;
	}

	public int getTomografo() {
		return tomografo;
	}

	public int getAmbulancia() {
		return ambulancia;
	}
	
}
