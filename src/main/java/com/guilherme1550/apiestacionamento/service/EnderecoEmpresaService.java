package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.EnderecoEmpresa;
import com.guilherme1550.apiestacionamento.repository.EnderecoEmpresaRepository;
import com.guilherme1550.apiestacionamento.service.validation.empresa.EnderecoEmpresaNaoCadastradoException;

@Service
public class EnderecoEmpresaService {
	
	@Autowired
	private EnderecoEmpresaRepository enderecoEmpresaRepository;
	
	public EnderecoEmpresa verificarSeEnderecoEmpresaExiste(String idEnderecoEmpresa) {
		Optional<EnderecoEmpresa> enderecoEmpresa = enderecoEmpresaRepository.findById(idEnderecoEmpresa);
		if(enderecoEmpresa.isEmpty()) {
			throw new EnderecoEmpresaNaoCadastradoException("Endereço da Empresa não cadastrado!");
		}
		return enderecoEmpresa.get();
	}
	
}
