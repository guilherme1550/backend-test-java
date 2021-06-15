package com.guilherme1550.apiestacionamento.controller.form;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

import com.guilherme1550.apiestacionamento.model.Empresa;

public class CadastroEmpresaForm {

	@NotNull(message = "O campo não pode ser nulo, favor digitar o nome da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o nome da Empresa")
	private String nome;
	
	@CNPJ
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Cnpj da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Cnpj da Empresa")
	private String cnpj;
	
	@Valid
	private List<CadastroEnderecoEmpresaForm> endereco;
	
	@Valid
	private List<CadastroTelefoneEmpresaForm> telefone;
	
	@Valid
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

	public List<CadastroTelefoneEmpresaForm> getTelefone() {
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
