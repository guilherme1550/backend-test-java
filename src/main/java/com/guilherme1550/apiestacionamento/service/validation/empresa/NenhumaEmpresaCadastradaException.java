package com.guilherme1550.apiestacionamento.service.validation.empresa;

public class NenhumaEmpresaCadastradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NenhumaEmpresaCadastradaException(String mensagem) {
		super(mensagem);
	}

}
