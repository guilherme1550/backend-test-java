package com.guilherme1550.apiestacionamento.controller.form;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.Usuario;

public class CadastroUsuarioEmpresaForm {
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
	
	public Usuario converterUsuario(Empresa empresa) {	
		return new Usuario(this.email, new BCryptPasswordEncoder().encode(this.senha), empresa);
	}
}
