package com.guilherme1550.apiestacionamento.service.validation.veiculo;

public class VeiculoJaCadastradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public VeiculoJaCadastradoException(String mensagem) {
		super(mensagem);
	}
}
