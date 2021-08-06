package com.guilherme1550.apiestacionamento.service.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizaTelefoneEmpresaForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Id do Telefone da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Id do Telefone da Empresa")
	private String idTelefoneEmpresa;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Telefone da Empresa")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Telefone da Empresa")
	private String numero;
	
	public String getIdTelefoneEmpresa() {
		return idTelefoneEmpresa;
	}
	public void setIdTelefoneEmpresa(String idTelefone) {
		this.idTelefoneEmpresa = idTelefone;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
