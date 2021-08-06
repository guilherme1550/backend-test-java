package com.guilherme1550.apiestacionamento.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.guilherme1550.apiestacionamento.model.Empresa;

public class EmpresaDto {
	private String id;
	private String nome;
	private String cnpj;
	private List<EnderecoEmpresaDto> endereco;
	private List<TelefoneEmpresaDto> telefone;
	private List<UsuarioEmpresaDto> usuario;

	public EmpresaDto(Empresa empresa, List<EnderecoEmpresaDto> enderecoEmpresa, List<TelefoneEmpresaDto> telefoneEmpresa,
			List<UsuarioEmpresaDto> usuarioEmpresa) {
		this.id = empresa.getId();
		this.nome = empresa.getNome();
		this.cnpj = empresa.getCnpj();
		this.endereco = enderecoEmpresa;
		this.telefone = telefoneEmpresa;
		this.usuario = usuarioEmpresa;
	}
		
	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public List<EnderecoEmpresaDto> getEndereco() {
		return endereco;
	}

	public List<TelefoneEmpresaDto> getTelefone() {
		return telefone;
	}

	public List<UsuarioEmpresaDto> getUsuario() {
		return usuario;
	}

	public static EmpresaDto converter(Empresa empresa) {
		List<EnderecoEmpresaDto> enderecoEmpresaDto = new ArrayList<>();
		empresa.getEnderecoEmpresa().forEach(endereco -> enderecoEmpresaDto.add(new EnderecoEmpresaDto(endereco)));
		
		List<TelefoneEmpresaDto> telefoneEmpresaDto = new ArrayList<>();
		empresa.getTelefoneEmpresa().forEach(telefone -> telefoneEmpresaDto.add(new TelefoneEmpresaDto(telefone)));
		
		List<UsuarioEmpresaDto> usuarioEmpresaDto = new ArrayList<>();
		empresa.getUsuarioEmpresa().forEach(usuario -> usuarioEmpresaDto.add(new UsuarioEmpresaDto(usuario)));
		
		return new EmpresaDto(empresa, enderecoEmpresaDto, telefoneEmpresaDto, usuarioEmpresaDto);
	}
}
