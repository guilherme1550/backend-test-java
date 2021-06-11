package com.guilherme1550.apiestacionamento.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "email", updatable = true, nullable = false)
	private String email;
	
	@Column(name = "senha", updatable = true, nullable = false)
	private String senha;
	
	@Column(name = "perfil", updatable = true, nullable = false)
	private String perfil;
	
	@ManyToOne
	private Empresa empresa;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getPerfis() {
		return perfil;
	}

	public void setPerfis(String perfil) {
		this.perfil = perfil;
	}
	
}
