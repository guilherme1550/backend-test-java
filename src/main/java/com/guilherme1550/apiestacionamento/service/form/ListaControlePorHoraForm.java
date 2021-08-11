package com.guilherme1550.apiestacionamento.service.form;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ListaControlePorHoraForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor preencher o Horário")
	@NotEmpty(message = "O campo não pode ser vazio, favor preencher o Horário")
	private String hora;

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
