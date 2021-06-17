package com.guilherme1550.apiestacionamento.controller.form;

import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;
import com.guilherme1550.apiestacionamento.model.Tipo;
import com.guilherme1550.apiestacionamento.model.Veiculo;

public class CadastroVeiculoForm {

	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private String tipo;
	private String idEnderecoEstacionamento;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIdEnderecoEstacionamento() {
		return idEnderecoEstacionamento;
	}

	public void setIdEnderecoEstacionamento(String idEnderecoEstacionamento) {
		this.idEnderecoEstacionamento = idEnderecoEstacionamento;
	}

	public Veiculo converterVeiculo(Empresa empresa, EnderecoEstacionamento enderecoEstacionamento) {
		if(this.tipo.equalsIgnoreCase("CARRO"))
			return new Veiculo(this.marca, this.modelo, this.cor, this.placa, Tipo.CARRO, empresa, enderecoEstacionamento);
		
		if(this.tipo.equalsIgnoreCase("MOTO"))
			return new Veiculo(this.marca, this.modelo, this.cor, this.placa, Tipo.MOTO, empresa, enderecoEstacionamento);
		
		return null;
	}
}
