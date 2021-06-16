package com.guilherme1550.apiestacionamento.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.UsuarioEmpresa;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${apiestacionamento.jwt.expiration}")
	private String expiration;

	@Value("${apiestacionamento.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		UsuarioEmpresa usuarioEmpresaLogado = (UsuarioEmpresa) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API Estacionamento")
				.setSubject(usuarioEmpresaLogado.getId())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
}
