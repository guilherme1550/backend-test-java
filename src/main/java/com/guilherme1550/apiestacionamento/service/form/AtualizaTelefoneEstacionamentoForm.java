package com.guilherme1550.apiestacionamento.service.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizaTelefoneEstacionamentoForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Id do Telefone do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Id do Telefone do Estacionamento")
	private String idTelefoneEstacionamento;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Numero do Telefone do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Numero do Telefone do Estacionamento")
	private String numero;

	public String getIdTelefoneEstacionamento() {
		return idTelefoneEstacionamento;
	}

	public void setIdTelefoneEstacionamento(String idTelefoneEstacionamento) {
		this.idTelefoneEstacionamento = idTelefoneEstacionamento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
