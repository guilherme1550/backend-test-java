package com.guilherme1550.apiestacionamento.controller.dto;

import com.guilherme1550.apiestacionamento.model.TelefoneEmpresa;

public class TelefoneEmpresaDto {
	private String idTelefoneEmpresa;
	private String numero;
	
	public TelefoneEmpresaDto(TelefoneEmpresa telefoneEmpresa) {
		this.idTelefoneEmpresa = telefoneEmpresa.getId();
		this.numero = telefoneEmpresa.getNumero();
	}

	public String getIdTelefoneEmpresa() {
		return idTelefoneEmpresa;
	}

	public String getNumero() {
		return numero;
	}

}
