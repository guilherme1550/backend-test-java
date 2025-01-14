package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;
import com.guilherme1550.apiestacionamento.model.Tipo;
import com.guilherme1550.apiestacionamento.repository.EnderecoEstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.EstacionamentoRepository;
import com.guilherme1550.apiestacionamento.service.validation.estacionamento.EnderecoEstacionamentoNaoCadastradoException;
import com.guilherme1550.apiestacionamento.service.validation.estacionamento.VagasParaCarroInsuficienteException;
import com.guilherme1550.apiestacionamento.service.validation.estacionamento.VagasParaMotoInsuficienteException;

@Service
public class EnderecoEstacionamentoService {

	@Autowired
	private EnderecoEstacionamentoRepository enderecoEstacionamentoRepository;
	
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;

	public EnderecoEstacionamento verificarSeEnderecoEstacionamentoExiste(String id) {
		Optional<EnderecoEstacionamento> enderecoEstacionamento = enderecoEstacionamentoRepository.findById(id);
		if (!enderecoEstacionamento.isPresent()) {
			throw new EnderecoEstacionamentoNaoCadastradoException(
					"Endereço do estacionamento não cadastrado no sistema!");
		}

		return enderecoEstacionamento.get();
	}

	public void verificarSeEnderecoEstacionamentoPossuiVaga(EnderecoEstacionamento enderecoEstacionamento,
			Tipo tipoVeiculo) {
		if (tipoVeiculo == Tipo.CARRO) {
			if (enderecoEstacionamento.getQtdVagasCarro().compareTo(1) < 0)
				throw new VagasParaCarroInsuficienteException(
						"Este estacionamento não possui vagas para Carros disponíveis.");
		} else if (tipoVeiculo == Tipo.MOTO) {
			if (enderecoEstacionamento.getQtdVagasMoto().compareTo(1) < 0)
				throw new VagasParaMotoInsuficienteException(
						"Este estacionamento não possui vagas para Motos disponíveis.");
		}

	}

	@Transactional
	public void addVaga(EnderecoEstacionamento enderecoEstacionamento, Tipo tipoVeiculo) {
		if (tipoVeiculo == Tipo.CARRO) {
			int vagasCarro = enderecoEstacionamento.getQtdVagasCarro() + 1;
			enderecoEstacionamento.setQtdVagasCarro(vagasCarro);
			enderecoEstacionamentoRepository.save(enderecoEstacionamento);
		} else if (tipoVeiculo == Tipo.MOTO) {
			int vagasMoto = enderecoEstacionamento.getQtdVagasMoto() + 1;
			enderecoEstacionamento.setQtdVagasMoto(vagasMoto);
			enderecoEstacionamentoRepository.save(enderecoEstacionamento);
		}
	}

	@Transactional
	public void subtrairVaga(EnderecoEstacionamento enderecoEstacionamento, Tipo tipoVeiculo) {
		if (tipoVeiculo == Tipo.CARRO) {
			int vagasCarro = enderecoEstacionamento.getQtdVagasCarro() - 1;
			enderecoEstacionamento.setQtdVagasCarro(vagasCarro);
			enderecoEstacionamentoRepository.save(enderecoEstacionamento);
		} else if (tipoVeiculo == Tipo.MOTO) {
			int vagasMoto = enderecoEstacionamento.getQtdVagasMoto() - 1;
			enderecoEstacionamento.setQtdVagasMoto(vagasMoto);
			enderecoEstacionamentoRepository.save(enderecoEstacionamento);
		}
	}
	
	public String getNomeEstacionamento(String idEnderecoEstacionamento) {
		String idEstacionamento = enderecoEstacionamentoRepository.getIdEstacionamento(idEnderecoEstacionamento);
		String nomeEstacionamento = estacionamentoRepository.findById(idEstacionamento).get().getNome();
		return nomeEstacionamento;
	}

}
