package com.guilherme1550.apiestacionamento.service.validation.estacionamento;

public class VagasParaCarroInsuficienteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VagasParaCarroInsuficienteException(String mensagem) {
		super(mensagem);
	}
}
