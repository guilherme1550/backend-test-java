package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.config.validation.VagasParaCarroInsuficienteException;
import com.guilherme1550.apiestacionamento.config.validation.VagasParaMotoInsuficienteException;
import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;
import com.guilherme1550.apiestacionamento.repository.EnderecoEstacionamentoRepository;

@Service
public class EnderecoEstacionamentoService {

	@Autowired
	EnderecoEstacionamentoRepository enderecoEstacionamentoRepository;

	public EnderecoEstacionamento verificarSeEnderecoEstacionamentoExiste(String id) {
		Optional<EnderecoEstacionamento> enderecoEstacionamento = enderecoEstacionamentoRepository.findById(id);
		if (enderecoEstacionamento.isPresent())
			return enderecoEstacionamento.get();

		return null;
	}

	public void verificarSeEnderecoEstacionamentoPossuiVaga(EnderecoEstacionamento enderecoEstacionamento,
			String tipoVeiculo) {
		if (tipoVeiculo.equalsIgnoreCase("Carro")) {
			if (enderecoEstacionamento.getQtdVagasCarro().compareTo(1) < 0)
				throw new VagasParaCarroInsuficienteException(
						"Este estacionamento não possui vagas para Carros disponíveis.");
		} else if (tipoVeiculo.equalsIgnoreCase("Moto")) {
			if (enderecoEstacionamento.getQtdVagasMoto().compareTo(1) < 1)
				throw new VagasParaMotoInsuficienteException(
						"Este estacionamento não possui vagas para Motos disponíveis.");
		}

	}

	@Transactional
	public void estacionarVeiculo(EnderecoEstacionamento enderecoEstacionamento, String tipoVeiculo) {
		if (tipoVeiculo.equalsIgnoreCase("Carro")) {
			int vagasCarro = enderecoEstacionamento.getQtdVagasCarro() - 1;
			enderecoEstacionamento.setQtdVagasCarro(vagasCarro);
			enderecoEstacionamentoRepository.save(enderecoEstacionamento);
		} else if (tipoVeiculo.equalsIgnoreCase("Moto")) {
			int vagasMoto = enderecoEstacionamento.getQtdVagasMoto() - 1;
			enderecoEstacionamento.setQtdVagasMoto(vagasMoto);
			enderecoEstacionamentoRepository.save(enderecoEstacionamento);
		}
	}
}
