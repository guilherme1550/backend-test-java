package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
}
