package com.guilherme1550.apiestacionamento.service.validation.estacionamento;

public class NenhumEstacionamentoCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NenhumEstacionamentoCadastradoException(String mensagem) {
		super(mensagem);
	}

}
