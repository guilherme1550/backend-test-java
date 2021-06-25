package com.guilherme1550.apiestacionamento.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.guilherme1550.apiestacionamento.model.Controle;
import com.guilherme1550.apiestacionamento.model.Estacionamento;
import com.guilherme1550.apiestacionamento.model.Veiculo;
import com.guilherme1550.apiestacionamento.repository.ControleRepository;
import com.guilherme1550.apiestacionamento.repository.EnderecoEstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.EstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.VeiculoRepository;

public class ListaControlePorEnderecoEstacionamentoDto {
	String idControle;
	LocalDateTime horaEntrada;
	LocalDateTime horaSaida;
	ControleVeiculoDto veiculo;
	ControleEstacionamentoDto estacionamento;

	public ListaControlePorEnderecoEstacionamentoDto(Controle controle, ControleVeiculoDto veiculo,
			ControleEstacionamentoDto estacionamento) {
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

	public static List<ListaControlePorEnderecoEstacionamentoDto> converter(EstacionamentoRepository estacionamentoRepository, EnderecoEstacionamentoRepository enderecoEstacionamentoRepository, ControleRepository controleRepository,
			VeiculoRepository veiculoRepository, String idEnderecoEstacionamento) {
		
		List<ListaControlePorEnderecoEstacionamentoDto> controleDto = new ArrayList<>();

		List<Veiculo> veiculos = veiculoRepository.findByEnderecoEstacionamentoId(idEnderecoEstacionamento);
		veiculos.forEach(veiculo -> {
			String idEstacionamento = enderecoEstacionamentoRepository
					.getIdEstacionamento(veiculo.getEnderecoEstacionamento().getId());
			Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(idEstacionamento);

			List<Controle> controles = controleRepository.findByVeiculoId(veiculo.getId());
			
			controles.forEach(controle -> controleDto.add
					(
						new ListaControlePorEnderecoEstacionamentoDto(
								controle,
								new ControleVeiculoDto(veiculo), 
								new ControleEstacionamentoDto(estacionamento.get().getNome(),
										veiculo.getEnderecoEstacionamento())
						)
					)
			);
		});

		return controleDto;
	}
}
