package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;


import com.guilherme1550.apiestacionamento.model.UsuarioEmpresa;
import com.guilherme1550.apiestacionamento.repository.UsuarioEmpresaRepository;
import com.guilherme1550.apiestacionamento.service.form.LoginUsuarioEmpresaForm;
import com.guilherme1550.apiestacionamento.service.validation.autenticacao.AutenticacaoException;
import com.guilherme1550.apiestacionamento.service.validation.empresa.EmailExistenteException;

@Service
public class UsuarioEmpresaService {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UsuarioEmpresaRepository usuarioRepository;
	
	@Autowired
	private TokenService tokenService;
	
	
	public String autenticar(LoginUsuarioEmpresaForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			return tokenService.gerarToken(authentication);
		} catch (AuthenticationException e) {
			throw new AutenticacaoException(e.getMessage());
		}
	}
	
	
	public void verificarSeEmailExiste(String email) {
		Optional<UsuarioEmpresa> usuario = usuarioRepository.findByEmail(email);
		if (usuario.isPresent()) {
			throw new EmailExistenteException("Email já cadastrado!");
		}
	}
}
