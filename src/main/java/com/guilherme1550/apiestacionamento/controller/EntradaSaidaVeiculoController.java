package com.guilherme1550.apiestacionamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme1550.apiestacionamento.controller.form.EntradaVeiculoForm;
import com.guilherme1550.apiestacionamento.controller.form.SaidaVeiculoForm;
import com.guilherme1550.apiestacionamento.model.Controle;
import com.guilherme1550.apiestacionamento.repository.ControleRepository;
import com.guilherme1550.apiestacionamento.repository.VeiculoRepository;
import com.guilherme1550.apiestacionamento.service.ControleService;

@RestController
@RequestMapping("/controle")
public class EntradaSaidaVeiculoController {

	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Autowired
	ControleRepository controleRepository;
	
	@Autowired
	ControleService controleService;
	
	@PostMapping("/entrada")
	public ResponseEntity<?> cadastrarEntradaVeiculo(@RequestBody @Valid EntradaVeiculoForm form) {
		Controle controle = form.converter(veiculoRepository);
		controleRepository.save(controle);
		return ResponseEntity.ok().build();
	}
	 
	@PostMapping("/saida")
	public ResponseEntity<?> cadastrarSaidaVeiculo(@RequestBody @Valid SaidaVeiculoForm form) {
		Controle controle = form.converter(controleRepository, controleService);
		controleRepository.save(controle);
		return ResponseEntity.ok().build();
	}
}
