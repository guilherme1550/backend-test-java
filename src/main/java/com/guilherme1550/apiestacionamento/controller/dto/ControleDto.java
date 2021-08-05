package com.guilherme1550.apiestacionamento.controller.dto;

import java.time.LocalDateTime;

import com.guilherme1550.apiestacionamento.model.Controle;
import com.guilherme1550.apiestacionamento.service.EnderecoEstacionamentoService;

public class ControleDto {
	private String idControle;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;
	private ControleVeiculoDto veiculo;
	private ControleEstacionamentoDto estacionamento;

	public ControleDto(Controle controle, ControleVeiculoDto veiculo, ControleEstacionamentoDto estacionamento) {
		this.idControle = controle.getId();
		this.horaEntrada = controle.getHoraEntrada();
		this.horaSaida = controle.getHoraSaida();
		this.veiculo = veiculo;
		this.estacionamento = estacionamento;
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

	public ControleVeiculoDto getVeiculo() {
		return veiculo;
	}

	public ControleEstacionamentoDto getEstacionamento() {
		return estacionamento;
	}

	public static ControleDto converter(EnderecoEstacionamentoService enderecoEstacionamentoService,
			Controle controle) {
		ControleVeiculoDto controleVeiculoDto = new ControleVeiculoDto(controle.getVeiculo());

		String nomeEstacionamento = enderecoEstacionamentoService
				.getNomeEstacionamento(controle.getEnderecoEstacionamento().getId());

		ControleEstacionamentoDto controleEstacionamentoDto = new ControleEstacionamentoDto(nomeEstacionamento,
				controle.getEnderecoEstacionamento());

		return new ControleDto(controle, controleVeiculoDto, controleEstacionamentoDto);
	}
}
