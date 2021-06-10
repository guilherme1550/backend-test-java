package com.guilherme1550.apiestacionamento.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Empresa {
	
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
	
	@Column(name = "endereco", updatable = true, nullable = false)
	private String endereco;
}
