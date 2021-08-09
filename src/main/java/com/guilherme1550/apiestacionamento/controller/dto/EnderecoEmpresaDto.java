package com.guilherme1550.apiestacionamento.controller.dto;

import com.guilherme1550.apiestacionamento.model.EnderecoEmpresa;

public class EnderecoEmpresaDto {
	private String idEnderecoEmpresa;
	private String cep;
	private String uf;
	private String bairro;
	private String logradouro;
	private String numero;
	private String complemento;
	
	public EnderecoEmpresaDto(EnderecoEmpresa enderecoEmpresa) {
		this.idEnderecoEmpresa = enderecoEmpresa.getId();
		this.cep = enderecoEmpresa.getCep();
		this.uf = enderecoEmpresa.getUf();
		this.bairro = enderecoEmpresa.getBairro();
		this.logradouro = enderecoEmpresa.getLogradouro();
		this.numero = enderecoEmpresa.getNumero();
		this.complemento = enderecoEmpresa.getComplemento();
	}

	public String getIdEnderecoEmpresa() {
		return idEnderecoEmpresa;
	}

	public String getCep() {
		return cep;
	}
	
	public String getUf() {
		return uf;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}
	
}
