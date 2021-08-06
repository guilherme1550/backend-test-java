package com.guilherme1550.apiestacionamento.service.form;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizaEmpresaForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Nome da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Nome da Empresa")
	private String nome;

	@Valid
	private List<AtualizaEnderecoEmpresaForm> endereco;
	
	@Valid
	private List<AtualizaTelefoneEmpresaForm> telefone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<AtualizaEnderecoEmpresaForm> getEndereco() {
		return endereco;
	}
	public void setEndereco(List<AtualizaEnderecoEmpresaForm> endereco) {
		this.endereco = endereco;
	}
	public List<AtualizaTelefoneEmpresaForm> getTelefone() {
		return telefone;
	}
	public void setTelefone(List<AtualizaTelefoneEmpresaForm> telefone) {
		this.telefone = telefone;
	}
	
}
