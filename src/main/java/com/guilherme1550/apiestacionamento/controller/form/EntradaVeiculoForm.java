package com.guilherme1550.apiestacionamento.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.guilherme1550.apiestacionamento.model.Controle;
import com.guilherme1550.apiestacionamento.model.Veiculo;
import com.guilherme1550.apiestacionamento.repository.VeiculoRepository;
import com.guilherme1550.apiestacionamento.service.validation.VeiculoNaoCadastradoException;

public class EntradaVeiculoForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o id do Veículo")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o id do Veículo")
	private String idVeiculo;

	public String getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(String idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	
	public Controle converter(VeiculoRepository veiculoRepository) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(idVeiculo);
		if (veiculo.isPresent())
			return new Controle(veiculo.get());
		
		throw new VeiculoNaoCadastradoException("Veículo não cadastrado no sistema.");
	}
}
