package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.TelefoneEmpresa;
import com.guilherme1550.apiestacionamento.repository.TelefoneEmpresaRepository;
import com.guilherme1550.apiestacionamento.service.validation.empresa.TelefoneEmpresaNaoCadastradoException;

@Service
public class TelefoneEmpresaService {
	
	@Autowired
	private TelefoneEmpresaRepository telefoneEmpresaRepository;
	
	public TelefoneEmpresa verificarSeTelefoneEmpresaExiste(String idTelefoneEmpresa) {
		Optional<TelefoneEmpresa> telefoneEmpresa = telefoneEmpresaRepository.findById(idTelefoneEmpresa);
		if (telefoneEmpresa.isEmpty()) {
			throw new TelefoneEmpresaNaoCadastradoException("Telefone da Empresa não cadastrado!");
		}
		return telefoneEmpresa.get();
	}
}
