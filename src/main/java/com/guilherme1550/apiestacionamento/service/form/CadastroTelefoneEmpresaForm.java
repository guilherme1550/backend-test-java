package com.guilherme1550.apiestacionamento.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.TelefoneEmpresa;

public class CadastroTelefoneEmpresaForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Telefone da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Telefone da Empresa")
	private String numero;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public TelefoneEmpresa converterTelefoneEmpresa(Empresa empresa) {
		return new TelefoneEmpresa(this.numero, empresa);
	}
	
}
