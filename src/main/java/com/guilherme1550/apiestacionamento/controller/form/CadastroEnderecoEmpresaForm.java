package com.guilherme1550.apiestacionamento.controller.form;

import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.EnderecoEmpresa;

public class CadastroEnderecoEmpresaForm {
	private String cep;
	private String uf;
	private String bairro;
	private String logradouro;
	private String numero;
	private String complemento;
	
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
	
	public EnderecoEmpresa converterEnderecoEmpresa(Empresa empresa) {
		return new EnderecoEmpresa(this.cep, this.uf, this.bairro, this.logradouro, this.numero, this.complemento, empresa);
	}
	
}

