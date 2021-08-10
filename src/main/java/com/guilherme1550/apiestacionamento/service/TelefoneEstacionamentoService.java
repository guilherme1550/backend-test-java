package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.TelefoneEstacionamento;
import com.guilherme1550.apiestacionamento.repository.TelefoneEstacionamentoRepository;
import com.guilherme1550.apiestacionamento.service.validation.estacionamento.TelefoneEstacionamentoException;

@Service
public class TelefoneEstacionamentoService {
	
	@Autowired
	TelefoneEstacionamentoRepository telefoneEstacionamentoRepository;
	
	public TelefoneEstacionamento verificarSeTelefoneEstacionamentoExiste(String idTelefoneEstacionamento) {
		Optional<TelefoneEstacionamento> telefoneEstacionamento = telefoneEstacionamentoRepository.findById(idTelefoneEstacionamento);
		if (telefoneEstacionamento.isEmpty()) {
			throw new TelefoneEstacionamentoException("Telefone não cadastrado no sistema!");
		}
		return telefoneEstacionamento.get();
	}
}
