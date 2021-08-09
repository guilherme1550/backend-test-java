package com.guilherme1550.apiestacionamento.controller.dto;

import com.guilherme1550.apiestacionamento.model.TelefoneEstacionamento;

public class TelefoneEstacionamentoDto {
	private String idTelefoneEstacionamento;
	private String numero;
	
	public TelefoneEstacionamentoDto(TelefoneEstacionamento telefoneEstacionamento) {
		this.idTelefoneEstacionamento = telefoneEstacionamento.getId();
		this.numero = telefoneEstacionamento.getNumero();
	}

	public String getIdTelefoneEstacionamento() {
		return idTelefoneEstacionamento;
	}

	public String getNumero() {
		return numero;
	}
	
}
