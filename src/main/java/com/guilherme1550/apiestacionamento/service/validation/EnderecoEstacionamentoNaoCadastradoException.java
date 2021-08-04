package com.guilherme1550.apiestacionamento.service.validation;

public class EnderecoEstacionamentoNaoCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EnderecoEstacionamentoNaoCadastradoException(String mensagem) {
		super(mensagem);
	}
}
