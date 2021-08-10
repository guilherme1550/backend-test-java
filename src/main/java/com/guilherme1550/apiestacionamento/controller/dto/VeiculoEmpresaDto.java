package com.guilherme1550.apiestacionamento.controller.dto;

import com.guilherme1550.apiestacionamento.model.Empresa;

public class VeiculoEmpresaDto {
	private String id;
	private String nome;
	private String cnpj;
	
	public VeiculoEmpresaDto(Empresa empresa) {
		this.id = empresa.getId();
		this.nome = empresa.getNome();
		this.cnpj = empresa.getCnpj();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

}
