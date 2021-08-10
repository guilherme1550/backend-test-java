package com.guilherme1550.apiestacionamento.service.form;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizaEstacionamentoForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Nome do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Nome do Estacionamento")
	private String nome;
	
	@Valid
	private List<AtualizaEnderecoEstacionamentoForm> endereco;
	
	@Valid
	private List<AtualizaTelefoneEstacionamentoForm> telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<AtualizaEnderecoEstacionamentoForm> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<AtualizaEnderecoEstacionamentoForm> endereco) {
		this.endereco = endereco;
	}

	public List<AtualizaTelefoneEstacionamentoForm> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<AtualizaTelefoneEstacionamentoForm> telefone) {
		this.telefone = telefone;
	}
	
}
