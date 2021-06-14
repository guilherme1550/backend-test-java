package com.guilherme1550.apiestacionamento.controller.form;


import java.util.List;

import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.Usuario;

public class CadastroEmpresaForm {
	private String nome;
	private String cnpj;
	private List<CadastroEnderecoEmpresaForm> endereco;
	private List<CadastroTelefoneEmpresaForm> telefone;
	private CadastroUsuarioEmpresaForm usuario;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public List<CadastroTelefoneEmpresaForm>getTelefone() {
		return telefone;
	}
	
	public void setTelefone(List<CadastroTelefoneEmpresaForm> telefone) {
		this.telefone = telefone;
	}
	
	public List<CadastroEnderecoEmpresaForm> getEndereco() {
		return endereco;
	}
	
	public void setEndereco(List<CadastroEnderecoEmpresaForm> endereco) {
		this.endereco = endereco;
	}
	
	public CadastroUsuarioEmpresaForm getUsuario() {
		return usuario;
	}
	
	public void setUsuario(CadastroUsuarioEmpresaForm usuario) {
		this.usuario = usuario;
	}
	
	public Empresa converterEmpresa() {
		return new Empresa(this.nome, this.cnpj);
	}
	
}
