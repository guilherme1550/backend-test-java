package com.guilherme1550.apiestacionamento.service.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;
import com.guilherme1550.apiestacionamento.model.Tipo;
import com.guilherme1550.apiestacionamento.model.Veiculo;
import com.guilherme1550.apiestacionamento.service.validation.veiculo.TipoVeiculoException;

public class CadastroVeiculoForm {

	@NotNull(message = "O campo não pode ser nulo, favor digitar a marca do Veículo")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar a marca do Veículo")
	private String marca;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o modelo do Veículo")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o modelo do Veículo")
	private String modelo;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar a cor do Veículo")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar a cor do Veículo")
	private String cor;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar a placa do Veículo")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar a placa do Veículo")
	private String placa;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o tipo do Veículo")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o tipo do Veículo")
	private String tipo;
	
	@NotNull(message = "O campo não pode ser nulo, favor fornecer o id do Endereço do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor fornecer o id do Endereço do Estacionamento")
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
		if(this.tipo.equalsIgnoreCase("CARRO")) {
			return new Veiculo(this.marca, this.modelo, this.cor, this.placa, Tipo.CARRO, empresa, enderecoEstacionamento);
		} else if(this.tipo.equalsIgnoreCase("MOTO")) {
			return new Veiculo(this.marca, this.modelo, this.cor, this.placa, Tipo.MOTO, empresa, enderecoEstacionamento);
		} else {
			throw new TipoVeiculoException("Tipo do Veículo inválido!");
		}
	}
}
