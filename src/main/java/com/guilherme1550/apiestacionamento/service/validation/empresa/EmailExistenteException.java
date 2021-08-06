package com.guilherme1550.apiestacionamento.service.validation.empresa;

public class EmailExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmailExistenteException(String mensagem) {
		super(mensagem);
	}
	
}
