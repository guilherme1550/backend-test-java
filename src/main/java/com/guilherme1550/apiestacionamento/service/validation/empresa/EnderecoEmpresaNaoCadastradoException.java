package com.guilherme1550.apiestacionamento.service.validation.empresa;

public class EnderecoEmpresaNaoCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EnderecoEmpresaNaoCadastradoException(String mensagem) {
		super(mensagem);
	}
	
}
