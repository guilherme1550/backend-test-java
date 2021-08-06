package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.UsuarioEmpresa;
import com.guilherme1550.apiestacionamento.repository.UsuarioEmpresaRepository;
import com.guilherme1550.apiestacionamento.service.validation.empresa.EmailExistenteException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioEmpresaRepository usuarioRepository;
	
	public void verificarSeEmailExiste(String email) {
		Optional<UsuarioEmpresa> usuario = usuarioRepository.findByEmail(email);
		if (usuario.isPresent()) {
			throw new EmailExistenteException("Email já cadastrado!");
		}
	}
}
