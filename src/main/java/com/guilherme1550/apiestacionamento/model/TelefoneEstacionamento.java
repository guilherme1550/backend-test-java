package com.guilherme1550.apiestacionamento.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class TelefoneEstacionamento {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column(name = "numero", updatable = true, nullable = false)
	private String numero;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Estacionamento estacionamento;
	
	public TelefoneEstacionamento() {}
	
	public TelefoneEstacionamento(String numero, Estacionamento estacionamento) {
		this.numero = numero;
		this.estacionamento = estacionamento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}
	
}
