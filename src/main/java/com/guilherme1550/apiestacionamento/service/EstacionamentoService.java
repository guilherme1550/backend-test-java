package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.Estacionamento;
import com.guilherme1550.apiestacionamento.repository.EstacionamentoRepository;

@Service
public class EstacionamentoService {
	
	@Autowired
	EstacionamentoRepository estacionamentoRepository;
	
	public String verificarSeEmailOuCnpjExiste(String email, String cnpj) {
		Optional<Estacionamento> emailExistenteEstacionamento = estacionamentoRepository.findByEmail(email);
		if (emailExistenteEstacionamento.isPresent())
			return "Email já cadastrado!";
		
		Optional<Estacionamento> cnpjExistenteEstacionamento = estacionamentoRepository.findByCnpj(cnpj);
		if (cnpjExistenteEstacionamento.isPresent())
			return "Cnpj já cadastrado!";
		
		return null;
			
	}
}
