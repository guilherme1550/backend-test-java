package com.guilherme1550.apiestacionamento.service.validation.empresa;

public class CnpjExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CnpjExistenteException(String mensagem) {
		super(mensagem);
	}
	
}
