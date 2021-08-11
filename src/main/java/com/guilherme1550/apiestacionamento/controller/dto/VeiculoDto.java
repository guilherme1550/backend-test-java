package com.guilherme1550.apiestacionamento.controller.dto;

import com.guilherme1550.apiestacionamento.model.Tipo;
import com.guilherme1550.apiestacionamento.model.Veiculo;

public class VeiculoDto {
	private String id;
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private Tipo tipo;
	private VeiculoEmpresaDto empresa;
	private VeiculoEstacionamentoDto estacionamento;

	public VeiculoDto(Veiculo veiculo, VeiculoEmpresaDto empresa, VeiculoEstacionamentoDto estacionamento) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.cor = veiculo.getCor();
		this.placa = veiculo.getPlaca();
		this.tipo = veiculo.getTipo();
		this.empresa = empresa;
		this.estacionamento = estacionamento;
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

	public VeiculoEstacionamentoDto getEstacionamento() {
		return estacionamento;
	}

	public static VeiculoDto converter(Veiculo veiculo) {
		return new VeiculoDto(veiculo, new VeiculoEmpresaDto(veiculo.getEmpresa()),
				new VeiculoEstacionamentoDto(veiculo.getEnderecoEstacionamento()));
	}
	
	

}
