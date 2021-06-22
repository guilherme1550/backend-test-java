package com.guilherme1550.apiestacionamento.config.validation;

public class VeiculoNaoSeEncontraNoEstacionamentoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public VeiculoNaoSeEncontraNoEstacionamentoException(String mensagem) {
		super(mensagem);
	}

}
