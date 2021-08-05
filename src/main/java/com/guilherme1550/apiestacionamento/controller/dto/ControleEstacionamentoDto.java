package com.guilherme1550.apiestacionamento.controller.dto;

import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;

public class ControleEstacionamentoDto {
	private String nome;
	private String cep;
	private String uf;
	private String bairro;
	private String logradouro;
	private String numero;
	private String complemento;
	
	
	
	public ControleEstacionamentoDto(String nome, EnderecoEstacionamento enderecoEstacionamento) {
		this.nome = nome;
		this.cep = enderecoEstacionamento.getCep();
		this.uf = enderecoEstacionamento.getUf();
		this.bairro = enderecoEstacionamento.getBairro();
		this.logradouro = enderecoEstacionamento.getLogradouro();
		this.numero = enderecoEstacionamento.getNumero();
		this.complemento = enderecoEstacionamento.getComplemento();
	}

	public String getNome() {
		return nome;
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
