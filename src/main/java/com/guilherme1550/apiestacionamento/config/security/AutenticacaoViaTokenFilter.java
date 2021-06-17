package com.guilherme1550.apiestacionamento.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.guilherme1550.apiestacionamento.model.UsuarioEmpresa;
import com.guilherme1550.apiestacionamento.repository.UsuarioEmpresaRepository;
import com.guilherme1550.apiestacionamento.service.TokenService;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UsuarioEmpresaRepository usuarioEmpresaRepository;

	public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioEmpresaRepository usuarioEmpresaRepository) {
		this.tokenService = tokenService;
		this.usuarioEmpresaRepository = usuarioEmpresaRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = recuperarToken(request);
		Boolean tokenValido = tokenService.validarToken(token);

		if (tokenValido)
			autenticarUsuarioEmpresa(token);

		filterChain.doFilter(request, response);
	}

	private void autenticarUsuarioEmpresa(String token) {
		String idUsuarioEmpresa = this.tokenService.getIdUsuarioEmpresa(token);
		UsuarioEmpresa usuarioEmpresa = usuarioEmpresaRepository.findById(idUsuarioEmpresa).get();

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuarioEmpresa,
				null, usuarioEmpresa.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer "))
			return null;

		return token.substring(7, token.length());
	}

}
