package com.guilherme1550.apiestacionamento.service.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SaidaVeiculoForm {

	@NotNull(message = "O campo não pode ser nulo, favor digitar o id do Controle")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o id do Controle")
	private String idControle;

	public String getIdControle() {
		return idControle;
	}

	public void setIdControle(String idControle) {
		this.idControle = idControle;
	}

}
