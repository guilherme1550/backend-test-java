package com.guilherme1550.apiestacionamento.controller.dto;

import java.util.List;

import com.guilherme1550.apiestacionamento.model.Perfil;
import com.guilherme1550.apiestacionamento.model.UsuarioEmpresa;

public class UsuarioEmpresaDto {
	private String idUsuario;
	private String email;
	private List<Perfil> perfil;
	
	public UsuarioEmpresaDto(UsuarioEmpresa usuarioEmpresa) {
		this.idUsuario = usuarioEmpresa.getId();
		this.email = usuarioEmpresa.getEmail();
		this.perfil = usuarioEmpresa.getPerfil();
	}

	public String getIdUsuario() {
		return idUsuario;
	}
	
	public String getEmail() {
		return email;
	}

	public List<Perfil> getPerfil() {
		return perfil;
	}
	
}
