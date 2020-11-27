package com.antonio.model;

public enum EnumRecurso {
	MEDICO(3), ENFERMEIRO(3), RESPIRADOR(5), TOMOGRAFO(12), AMBULANCIA(10);

	private final int valor;

	EnumRecurso(int valorOpcao) {
		valor = valorOpcao;
	}

	public int getValor() {
		return valor;
	}

}
