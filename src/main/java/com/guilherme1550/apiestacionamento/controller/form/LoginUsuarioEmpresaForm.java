package com.guilherme1550.apiestacionamento.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginUsuarioEmpresaForm {
	
	private String email;
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(this.email, this.senha);
	}
}
