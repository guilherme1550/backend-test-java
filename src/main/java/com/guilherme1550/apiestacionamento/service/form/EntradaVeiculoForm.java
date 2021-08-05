package com.guilherme1550.apiestacionamento.service.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.guilherme1550.apiestacionamento.model.Controle;
import com.guilherme1550.apiestacionamento.model.Veiculo;
import com.guilherme1550.apiestacionamento.repository.VeiculoRepository;


public class EntradaVeiculoForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o id do Veículo")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o id do Veículo")
	private String idVeiculo;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o id do Endereco do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o id do Endereco do Estacionamento")
	private String idEnderecoEstacionamento;

	public String getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(String idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	
	public String getIdEnderecoEstacionamento() {
		return idEnderecoEstacionamento;
	}

	public void setIdEnderecoEstacionamento(String idEnderecoEstacionamento) {
		this.idEnderecoEstacionamento = idEnderecoEstacionamento;
	}

	public Controle converter(VeiculoRepository veiculoRepository) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(idVeiculo);
		return new Controle(veiculo.get());
	}
}
