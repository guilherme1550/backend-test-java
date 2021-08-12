package com.guilherme1550.apiestacionamento.service.validation.controle;

public class VeiculoNaoSeEncontraNoEstacionamentoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public VeiculoNaoSeEncontraNoEstacionamentoException(String mensagem) {
		super(mensagem);
	}

}
