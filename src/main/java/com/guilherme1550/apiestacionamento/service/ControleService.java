package com.guilherme1550.apiestacionamento.service;

import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.config.validation.VeiculoNaoSeEncontraNoEstacionamentoException;
import com.guilherme1550.apiestacionamento.model.Controle;

@Service
public class ControleService {
	
	public void verificarSeVeiculoNaoSaiuDoEstacionamento(Controle controle) {
		if (controle.getHoraSaida() != null)
			throw new VeiculoNaoSeEncontraNoEstacionamentoException("Este veículo já realizou a saída do estacionamento!");
	}
}