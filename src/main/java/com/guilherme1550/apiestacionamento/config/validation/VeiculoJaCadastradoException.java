package com.guilherme1550.apiestacionamento.config.validation;

public class VeiculoJaCadastradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public VeiculoJaCadastradoException(String mensagem) {
		super(mensagem);
	}
}
