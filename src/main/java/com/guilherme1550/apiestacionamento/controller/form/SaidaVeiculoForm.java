package com.guilherme1550.apiestacionamento.controller.form;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.guilherme1550.apiestacionamento.config.validation.ControleNaoEncontradoException;
import com.guilherme1550.apiestacionamento.model.Controle;
import com.guilherme1550.apiestacionamento.repository.ControleRepository;
import com.guilherme1550.apiestacionamento.service.ControleService;

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
	
	public Controle converter(ControleRepository controleRepository, ControleService controleService) {
		Optional<Controle> controleOptional = controleRepository.findById(idControle);
		if (controleOptional.isPresent()) {
			Controle controle = controleOptional.get();
			controleService.verificarSeVeiculoNaoSaiuDoEstacionamento(controle);
			controle.setHoraSaida(LocalDateTime.now());
			return controle;
		}
		
		throw new ControleNaoEncontradoException("Controle não encontrado!");
			
	}
}
