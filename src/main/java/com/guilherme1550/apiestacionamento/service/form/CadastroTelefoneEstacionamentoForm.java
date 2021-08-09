package com.guilherme1550.apiestacionamento.service.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.guilherme1550.apiestacionamento.model.Estacionamento;
import com.guilherme1550.apiestacionamento.model.TelefoneEstacionamento;

public class CadastroTelefoneEstacionamentoForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Telefone do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Telefone do Estacionamento")
	private String numero;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public TelefoneEstacionamento converterTelefoneEstacionamento(Estacionamento estacionamento) {
		return new TelefoneEstacionamento(this.numero, estacionamento);
	}
}
