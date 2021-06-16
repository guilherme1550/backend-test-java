package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.UsuarioEmpresa;
import com.guilherme1550.apiestacionamento.repository.UsuarioEmpresaRepository;

@Service
public class AutenticacaoUsuarioEmpresaService implements UserDetailsService {

	@Autowired
	private UsuarioEmpresaRepository usuarioEmpresaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioEmpresa> usuarioEmpresa = usuarioEmpresaRepository.findByEmail(username);
		if (usuarioEmpresa.isPresent())
			return usuarioEmpresa.get();
		
		throw new UsernameNotFoundException("Usuário ou senha inválido!");
	}

}
