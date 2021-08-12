package com.guilherme1550.apiestacionamento.service.validation.estacionamento;

public class TelefoneEstacionamentoNaoCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TelefoneEstacionamentoNaoCadastradoException(String mensagem) {
		super(mensagem);
	}

}
