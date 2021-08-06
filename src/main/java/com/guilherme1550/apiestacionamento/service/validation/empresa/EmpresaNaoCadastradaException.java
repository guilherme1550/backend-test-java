package com.guilherme1550.apiestacionamento.service.validation.empresa;

public class EmpresaNaoCadastradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmpresaNaoCadastradaException(String mensagem) {
		super(mensagem);
	}
	
}
