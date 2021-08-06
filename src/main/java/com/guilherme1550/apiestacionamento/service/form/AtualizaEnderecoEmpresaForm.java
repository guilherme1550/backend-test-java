package com.guilherme1550.apiestacionamento.service.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizaEnderecoEmpresaForm {
	
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Id do Endereço da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Id do Endereço da Empresa")
	private String idEnderecoEmpresa;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Cep da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Cep da Empresa")
	private String cep;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o UF da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o UF da Empresa")
	private String uf;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Bairro da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Bairro da Empresa")
	private String bairro;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Logradouro da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Logradouro da Empresa")
	private String logradouro;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Numero da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Numero da Empresa")
	private String numero;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Complemento da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Complemento da Empresa")
	private String complemento;
	
	public String getIdEnderecoEmpresa() {
		return idEnderecoEmpresa;
	}
	public void setIdEnderecoEmpresa(String idEnderecoEmpresa) {
		this.idEnderecoEmpresa = idEnderecoEmpresa;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
