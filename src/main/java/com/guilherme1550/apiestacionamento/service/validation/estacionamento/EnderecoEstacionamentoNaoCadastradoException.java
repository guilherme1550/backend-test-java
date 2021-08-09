package com.guilherme1550.apiestacionamento.service.validation.estacionamento;

public class EnderecoEstacionamentoNaoCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EnderecoEstacionamentoNaoCadastradoException(String mensagem) {
		super(mensagem);
	}
}
