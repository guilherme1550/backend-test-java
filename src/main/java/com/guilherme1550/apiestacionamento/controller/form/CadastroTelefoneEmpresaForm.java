package com.guilherme1550.apiestacionamento.controller.form;

import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.TelefoneEmpresa;

public class CadastroTelefoneEmpresaForm {
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
