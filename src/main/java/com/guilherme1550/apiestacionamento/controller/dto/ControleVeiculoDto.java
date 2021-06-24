package com.guilherme1550.apiestacionamento.controller.dto;

import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.Tipo;
import com.guilherme1550.apiestacionamento.model.Veiculo;

public class ControleVeiculoDto {
	String id;
	String marca;
	String modelo;
	String cor;
	String placa;
	Tipo tipo;
	Empresa empresa;
	
	public ControleVeiculoDto(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.cor = veiculo.getCor();
		this.placa = veiculo.getPlaca();
		this.tipo = veiculo.getTipo();
		this.empresa = veiculo.getEmpresa();
	}

	public String getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCor() {
		return cor;
	}

	public String getPlaca() {
		return placa;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}
}
