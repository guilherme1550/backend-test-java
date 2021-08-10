package com.guilherme1550.apiestacionamento.controller.dto;

import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;

public class VeiculoEstacionamentoDto {
	private String id;
	private String nome;
	private String cnpj;
	private String uf;
	private String bairro;
	private String logradouro;
	private String numero;
	private String complemento;
	
	public VeiculoEstacionamentoDto(EnderecoEstacionamento enderecoEstacionamento) {
		this.id = enderecoEstacionamento.getEstacionamento().getId();
		this.nome = enderecoEstacionamento.getEstacionamento().getNome();
		this.cnpj = enderecoEstacionamento.getEstacionamento().getCnpj();
		this.uf = enderecoEstacionamento.getUf();
		this.bairro = enderecoEstacionamento.getBairro();
		this.logradouro = enderecoEstacionamento.getLogradouro();
		this.numero = enderecoEstacionamento.getNumero();
		this.complemento = enderecoEstacionamento.getComplemento();
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
