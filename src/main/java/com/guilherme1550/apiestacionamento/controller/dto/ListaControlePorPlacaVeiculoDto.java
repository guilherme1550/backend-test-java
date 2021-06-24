package com.guilherme1550.apiestacionamento.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.guilherme1550.apiestacionamento.config.validation.VeiculoNaoCadastradoException;
import com.guilherme1550.apiestacionamento.model.Controle;
import com.guilherme1550.apiestacionamento.model.Estacionamento;
import com.guilherme1550.apiestacionamento.model.Veiculo;
import com.guilherme1550.apiestacionamento.repository.ControleRepository;
import com.guilherme1550.apiestacionamento.repository.EnderecoEstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.EstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.VeiculoRepository;

public class ListaControlePorPlacaVeiculoDto {
	String idControle;
	LocalDateTime horaEntrada;
	LocalDateTime horaSaida;
	ControleVeiculoDto veiculo;
	ControleEstacionamentoDto estacionamento;

	// Veiculo veiculo;
	// String nomeEstacionamento;

	public ListaControlePorPlacaVeiculoDto(Controle controle, ControleVeiculoDto veiculo,
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

	public static List<ListaControlePorPlacaVeiculoDto> converter(
			EnderecoEstacionamentoRepository enderecoEstacionamentoRepository,
			EstacionamentoRepository estacionamentoRepository, VeiculoRepository veiculoRepository,
			ControleRepository controleRepository, String idPlacaVeiculo) {

		Optional<Veiculo> veiculo = veiculoRepository.findByPlaca(idPlacaVeiculo);
		if (!veiculo.isPresent())
			throw new VeiculoNaoCadastradoException("Veiculo não cadastrado no sistema!");

		String idEstacionamento = enderecoEstacionamentoRepository
				.getIdEstacionamento(veiculo.get().getEnderecoEstacionamento().getId());
		Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(idEstacionamento);

		List<Controle> controles = controleRepository.findByVeiculoId(veiculo.get().getId());

		List<ListaControlePorPlacaVeiculoDto> controleDto = new ArrayList<>();
		controles.forEach(controle -> controleDto.add
				(
					new ListaControlePorPlacaVeiculoDto(
							controle,
							new ControleVeiculoDto(veiculo.get()), 
							new ControleEstacionamentoDto(estacionamento.get().getNome(),
									veiculo.get().getEnderecoEstacionamento())
					)
				)
		);

		return controleDto;
	}

}
