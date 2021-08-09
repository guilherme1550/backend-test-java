package com.guilherme1550.apiestacionamento.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class EnderecoEmpresa {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column(name = "cep", updatable = true, nullable = false)
	private String cep;
	
	@Column(name = "uf", updatable = true, nullable = false)
	private String uf;
	
	@Column(name = "bairro", updatable = true, nullable = false)
	private String bairro;
	
	@Column(name = "logradouro", updatable = true, nullable = false)
	private String logradouro;
	
	@Column(name = "numero", updatable = true, nullable = false)
	private String numero;
	
	@Column(name = "complemento", updatable = true, nullable = false)
	private String complemento;
	
	@ManyToOne()
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Empresa empresa;

	public EnderecoEmpresa() {}
	
	public EnderecoEmpresa(String cep, String uf, String bairro, String logradouro, String numero, String complemento, Empresa empresa) {
		this.cep = cep;
		this.uf = uf;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.empresa = empresa;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
