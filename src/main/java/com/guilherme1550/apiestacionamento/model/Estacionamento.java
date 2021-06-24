package com.guilherme1550.apiestacionamento.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Estacionamento {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

	@Column(name = "nome", updatable = true, nullable = false)
	private String nome;

	@Column(name = "cnpj", updatable = true, nullable = false)
	private String cnpj;

	@Column(name = "email", updatable = true, nullable = false)
	private String email;

	@Column(name = "senha", updatable = true, nullable = false)
	private String senha;
	
	@OneToMany(mappedBy = "estacionamento")
	private List<EnderecoEstacionamento> enderecoEstacionamento;
	
	@OneToMany(mappedBy = "estacionamento")
	private List<TelefoneEstacionamento> telefoneEstacionamento;

	public Estacionamento() {
	}

	public Estacionamento(String nome, String cnpj, String email, String senha) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.senha = senha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<EnderecoEstacionamento> getEnderecoEstacionamento() {
		return enderecoEstacionamento;
	}

	public void setEnderecoEstacionamento(List<EnderecoEstacionamento> enderecoEstacionamento) {
		this.enderecoEstacionamento = enderecoEstacionamento;
	}

	public List<TelefoneEstacionamento> getTelefoneEstacionamento() {
		return telefoneEstacionamento;
	}

	public void setTelefoneEstacionamento(List<TelefoneEstacionamento> telefoneEstacionamento) {
		this.telefoneEstacionamento = telefoneEstacionamento;
	}
	
}
