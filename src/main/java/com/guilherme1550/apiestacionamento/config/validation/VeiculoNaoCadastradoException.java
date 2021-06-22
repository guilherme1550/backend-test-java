package com.guilherme1550.apiestacionamento.config.validation;

public class VeiculoNaoCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public VeiculoNaoCadastradoException(String mensagem) {
		super(mensagem);
	}

}
