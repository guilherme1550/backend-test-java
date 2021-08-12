package com.guilherme1550.apiestacionamento.service.validation.veiculo;

public class VeiculoJaCadastradoNoEstacionamentoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public VeiculoJaCadastradoNoEstacionamentoException(String mensagem) {
		super(mensagem);
	}

}
