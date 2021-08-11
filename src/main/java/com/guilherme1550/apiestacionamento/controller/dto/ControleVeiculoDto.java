package com.guilherme1550.apiestacionamento.controller.dto;

import com.guilherme1550.apiestacionamento.model.Tipo;
import com.guilherme1550.apiestacionamento.model.Veiculo;

public class ControleVeiculoDto {
	private String id;
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private Tipo tipo;
	private VeiculoEmpresaDto empresa;
	
	public ControleVeiculoDto(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.cor = veiculo.getCor();
		this.placa = veiculo.getPlaca();
		this.tipo = veiculo.getTipo();
		this.empresa = new VeiculoEmpresaDto(veiculo.getEmpresa());
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

	public VeiculoEmpresaDto getEmpresa() {
		return empresa;
	}
}
