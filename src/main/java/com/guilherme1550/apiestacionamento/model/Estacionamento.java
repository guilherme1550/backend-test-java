package com.guilherme1550.apiestacionamento.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Estacionamento {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "nome", updatable = true, nullable = false)
	private String nome;

	@Column(name = "cnpj", updatable = true, nullable = false)
	private String cnpj;

	@Column(name = "email", updatable = true, nullable = false)
	private String email;

	@Column(name = "senha", updatable = true, nullable = false)
	private String senha;

	public Estacionamento() {}
	
	public Estacionamento(String nome, String cnpj, String email, String senha) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.senha = senha;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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
}
