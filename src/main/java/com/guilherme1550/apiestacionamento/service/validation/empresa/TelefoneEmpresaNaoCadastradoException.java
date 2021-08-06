package com.guilherme1550.apiestacionamento.service.validation.empresa;

public class TelefoneEmpresaNaoCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TelefoneEmpresaNaoCadastradoException(String mensagem) {
		super(mensagem);
	}
}
