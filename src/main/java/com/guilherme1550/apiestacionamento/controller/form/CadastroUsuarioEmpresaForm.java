package com.guilherme1550.apiestacionamento.controller.form;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.id.UUIDGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.Perfil;
import com.guilherme1550.apiestacionamento.model.UsuarioEmpresa;
import com.guilherme1550.apiestacionamento.repository.PerfilRepository;
import com.guilherme1550.apiestacionamento.service.PerfilService;

public class CadastroUsuarioEmpresaForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Email do Usuário")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Email do Usuário")
	@Email(message = "Email inválido")
	private String email;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar a Senha do Usuário")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar a Senha do Usuário")
	private String senha;
	
	private List<String> perfis;
	
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

	public List<String> getPerfis() {
		return perfis;
	}
	
	public void setPerfis(List<String> perfis) {
		this.perfis = perfis;
	}

	public UsuarioEmpresa converterUsuario(Empresa empresa, PerfilService perfilService) {	
		List<Perfil> perfisUsuario = perfilService.selecionarPerfis(this.perfis);
		return new UsuarioEmpresa(this.email, new BCryptPasswordEncoder().encode(this.senha), perfisUsuario, empresa);
	}
}
