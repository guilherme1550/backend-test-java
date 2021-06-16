package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.UsuarioEmpresa;
import com.guilherme1550.apiestacionamento.repository.UsuarioEmpresaRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioEmpresaRepository usuarioRepository;
	
	public String verificarSeEmailExiste(String email) {
		Optional<UsuarioEmpresa> usuario = usuarioRepository.findByEmail(email);
		
		if (usuario.isPresent()) {
			return "Email já cadastrado!";
		}
		
		return null;
	}
	
}
