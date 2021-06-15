package com.guilherme1550.apiestacionamento.controller.form;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.guilherme1550.apiestacionamento.model.Estacionamento;

public class CadastroEstacionamentoForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o nome do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o nome do Estacionamento")
	private String nome;

	@CNPJ
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Cnpj do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Cnpj do Estacionamento")
	private String cnpj;

	@Email(message = "Email inválido")
	@NotNull(message = "O campo não pode ser nulo, favor digitar o email do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o email do Estacionamento")
	private String email;

	@NotNull(message = "O campo não pode ser nulo, favor digitar a senha do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar a senha do Estacionamento")
	private String senha;

	@Valid
	private List<CadastroEnderecoEstacionamentoForm> endereco;

	@Valid
	private List<CadastroTelefoneEstacionamentoForm> telefone;

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

	public List<CadastroEnderecoEstacionamentoForm> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<CadastroEnderecoEstacionamentoForm> endereco) {
		this.endereco = endereco;
	}

	public List<CadastroTelefoneEstacionamentoForm> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<CadastroTelefoneEstacionamentoForm> telefone) {
		this.telefone = telefone;
	}
	
	public Estacionamento converterEstacionamento() {
		return new Estacionamento(this.nome, this.cnpj, this.email, new BCryptPasswordEncoder().encode(this.senha));
	}
}
