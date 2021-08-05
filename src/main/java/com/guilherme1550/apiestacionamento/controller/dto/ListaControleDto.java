package com.guilherme1550.apiestacionamento.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.guilherme1550.apiestacionamento.model.Controle;
import com.guilherme1550.apiestacionamento.service.EnderecoEstacionamentoService;

public class ListaControleDto {
	String idControle;
	LocalDateTime horaEntrada;
	LocalDateTime horaSaida;
	ControleVeiculoDto veiculo;
	ControleEstacionamentoDto estacionamento;

	public ListaControleDto(Controle controle, ControleVeiculoDto veiculo,
			ControleEstacionamentoDto estacionamento) {
		this.idControle = controle.getId();
		this.horaEntrada = controle.getHoraEntrada();
		this.horaSaida = controle.getHoraSaida();
		this.veiculo = veiculo;
		this.estacionamento = estacionamento;
	}

	public ControleVeiculoDto getVeiculo() {
		return veiculo;
	}

	public ControleEstacionamentoDto getEstacionamento() {
		return estacionamento;
	}

	public String getIdControle() {
		return idControle;
	}

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public LocalDateTime getHoraSaida() {
		return horaSaida;
	}

	public static List<ListaControleDto> converter(
			EnderecoEstacionamentoService enderecoEstacionamentoService, List<Controle> controles) {

		List<ListaControleDto> controleDto = new ArrayList<>();
		controles.forEach(controle -> controleDto
				.add(new ListaControleDto(controle, new ControleVeiculoDto(controle.getVeiculo()),
						new ControleEstacionamentoDto(
								enderecoEstacionamentoService
										.getNomeEstacionamento(controle.getEnderecoEstacionamento().getId()),
								controle.getEnderecoEstacionamento()))));

		return controleDto;
	}

}
