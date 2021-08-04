package com.guilherme1550.apiestacionamento.service.validation;

public class VagasParaMotoInsuficienteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VagasParaMotoInsuficienteException(String mensagem) {
		super(mensagem);
	}
}
