package com.guilherme1550.apiestacionamento.controller.dto;

import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;

public class ControleEstacionamentoDto {
	String nome;
	EnderecoEstacionamento enderecoEstacionamento;
	
	public ControleEstacionamentoDto(String nome, EnderecoEstacionamento enderecoEstacionamento) {
		this.nome = nome;
		this.enderecoEstacionamento = enderecoEstacionamento;
	}

	public String getNome() {
		return nome;
	}

	public EnderecoEstacionamento getEnderecoEstacionamento() {
		return enderecoEstacionamento;
	}
	
}
