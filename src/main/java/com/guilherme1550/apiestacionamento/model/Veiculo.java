package com.guilherme1550.apiestacionamento.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column(name = "marca", updatable = true, nullable = false)
	private String marca;
	
	@Column(name = "modelo", updatable = true, nullable = false)
	private String modelo;
	
	@Column(name = "cor", updatable = true, nullable = false)
	private String cor;
	
	@Column(name = "placa", updatable = true, nullable = false)
	private String placa;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToOne
	private EnderecoEstacionamento enderecoEstacionamento;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public EnderecoEstacionamento getEnderecoEstacionamento() {
		return enderecoEstacionamento;
	}

	public void setEnderecoEstacionamento(EnderecoEstacionamento enderecoEstacionamento) {
		this.enderecoEstacionamento = enderecoEstacionamento;
	}

}
