package com.guilherme1550.apiestacionamento.service.validation.estacionamento;

public class EstacionamentoNaoCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EstacionamentoNaoCadastradoException(String mensagem) {
		super(mensagem);
	}

}
