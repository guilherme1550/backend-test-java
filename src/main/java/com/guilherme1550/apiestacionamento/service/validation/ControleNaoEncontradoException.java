package com.guilherme1550.apiestacionamento.service.validation;

public class ControleNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ControleNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}
