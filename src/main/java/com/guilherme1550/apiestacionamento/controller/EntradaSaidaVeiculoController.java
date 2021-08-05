package com.guilherme1550.apiestacionamento.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme1550.apiestacionamento.controller.dto.ControleDto;
import com.guilherme1550.apiestacionamento.controller.dto.ListaControleDto;
import com.guilherme1550.apiestacionamento.model.Controle;

import com.guilherme1550.apiestacionamento.service.ControleService;
import com.guilherme1550.apiestacionamento.service.EnderecoEstacionamentoService;
import com.guilherme1550.apiestacionamento.service.form.EntradaVeiculoForm;
import com.guilherme1550.apiestacionamento.service.form.SaidaVeiculoForm;

@RestController
@RequestMapping("/controle")
public class EntradaSaidaVeiculoController {

	@Autowired
	private EnderecoEstacionamentoService enderecoEstacionamentoService;

	@Autowired
	private ControleService controleService;

	@PostMapping("/entrada")
	public ResponseEntity<?> cadastrarEntradaVeiculo(@RequestBody @Valid EntradaVeiculoForm form) {
		Controle controle = controleService.entradaVeiculo(form);
		return ResponseEntity.ok(ControleDto.converter(enderecoEstacionamentoService, controle));
	}

	@PostMapping("/saida")
	public ResponseEntity<?> cadastrarSaidaVeiculo(@RequestBody @Valid SaidaVeiculoForm form) {
		Controle controle = controleService.saidaVeiculo(form);
		return ResponseEntity.ok(ControleDto.converter(enderecoEstacionamentoService, controle));
	}

	@GetMapping("/veiculo/{idPlacaVeiculo}")
	public ResponseEntity<?> listarPorPlacaVeiculo(@PathVariable String idPlacaVeiculo) {
		List<Controle> controles = controleService.listarPorPlacaVeiculo(idPlacaVeiculo);
		return ResponseEntity.ok(ListaControleDto.converter(enderecoEstacionamentoService, controles));
	}

	@GetMapping("/endereco-estacionamento/{idEnderecoEstacionamento}")
	public ResponseEntity<?> listarPorEnderecoEstacionamento(@PathVariable String idEnderecoEstacionamento) {
		List<Controle> controles = controleService.listarPorEnderecoEstacionamento(idEnderecoEstacionamento);
		return ResponseEntity
				.ok(ListaControleDto.converter(enderecoEstacionamentoService, controles));
	}
}
