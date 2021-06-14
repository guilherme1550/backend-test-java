package com.guilherme1550.apiestacionamento.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.Usuario;

public class CadastroUsuarioEmpresaForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Email do Usuário")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Email do Usuário")
	@Email(message = "Email inválido")
	private String email;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar a Senha do Usuário")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar a Senha do Usuário")
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
