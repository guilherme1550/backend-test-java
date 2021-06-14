package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	public String verificarSeCnpjExiste(String cnpj) {
		Optional<Empresa> empresa = empresaRepository.findByCnpj(cnpj);
		
		if(empresa.isPresent()) {
			return "Cnpj já cadastrado!";
		}
		
		return null;
	}
}
