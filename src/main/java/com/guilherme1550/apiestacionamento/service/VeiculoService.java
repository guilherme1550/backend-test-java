package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.config.validation.VeiculoJaCadastradoException;
import com.guilherme1550.apiestacionamento.model.Veiculo;
import com.guilherme1550.apiestacionamento.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	VeiculoRepository veiculoRepository;
	
	public ResponseEntity<?> verificarSeVeiculoExiste(String placa) {
		Optional<Veiculo> veiculo = veiculoRepository.findByPlaca(placa);
		if (veiculo.isPresent())
			throw new VeiculoJaCadastradoException("Veículo já cadastrado no sistema.");
			
		return null;
	}
}
