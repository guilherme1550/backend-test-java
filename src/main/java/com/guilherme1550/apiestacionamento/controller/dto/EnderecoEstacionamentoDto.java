package com.guilherme1550.apiestacionamento.controller.dto;

import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;

public class EnderecoEstacionamentoDto {
	private String id;
	private String cep;
	private String uf;
	private String bairro;
	private String logradouro;
	private String numero;
	private String complemento;
	private Integer qtdVagasMoto;
	private Integer qtdVagasCarro;
	
	public EnderecoEstacionamentoDto(EnderecoEstacionamento enderecoEstacionamento) {
		this.id = enderecoEstacionamento.getId();
		this.cep = enderecoEstacionamento.getCep();
		this.uf = enderecoEstacionamento.getUf();
		this.bairro = enderecoEstacionamento.getBairro();
		this.logradouro = enderecoEstacionamento.getLogradouro();
		this.numero = enderecoEstacionamento.getNumero();
		this.complemento = enderecoEstacionamento.getComplemento();
		this.qtdVagasMoto = enderecoEstacionamento.getQtdVagasMoto();
		this.qtdVagasCarro = enderecoEstacionamento.getQtdVagasCarro();
	}

	public String getId() {
		return id;
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

	public Integer getQtdVagasMoto() {
		return qtdVagasMoto;
	}

	public Integer getQtdVagasCarro() {
		return qtdVagasCarro;
	}
	
}
