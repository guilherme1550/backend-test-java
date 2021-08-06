package com.guilherme1550.apiestacionamento.service.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizaVeiculoDeEstacionamentoForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Id do Veiculo")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Id do Veiculo")
	private String idVeiculo;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Id do do Endereco do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Id do Endereco do Estacionamento")
	private String idEnderecoEstacionamento;

	public String getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(String idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getIdEnderecoEstacionamento() {
		return idEnderecoEstacionamento;
	}

	public void setIdEnderecoEstacionamento(String idEnderecoEstacionamento) {
		this.idEnderecoEstacionamento = idEnderecoEstacionamento;
	}
	
}
