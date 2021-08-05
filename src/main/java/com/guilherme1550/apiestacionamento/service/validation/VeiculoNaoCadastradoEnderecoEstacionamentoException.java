package com.guilherme1550.apiestacionamento.service.validation;

public class VeiculoNaoCadastradoEnderecoEstacionamentoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VeiculoNaoCadastradoEnderecoEstacionamentoException(String mensagem) {
		super(mensagem);
	}
}
