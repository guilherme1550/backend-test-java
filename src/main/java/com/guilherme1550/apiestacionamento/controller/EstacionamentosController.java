package com.guilherme1550.apiestacionamento.controller;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.guilherme1550.apiestacionamento.controller.dto.EstacionamentoDto;
import com.guilherme1550.apiestacionamento.repository.EnderecoEstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.EstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.TelefoneEstacionamentoRepository;
import com.guilherme1550.apiestacionamento.service.EstacionamentoService;
import com.guilherme1550.apiestacionamento.service.form.CadastroEstacionamentoForm;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentosController {

	@Autowired
	EstacionamentoRepository estacionamentoRepository;

	@Autowired
	EnderecoEstacionamentoRepository enderecoEstacionamentoRepository;

	@Autowired
	TelefoneEstacionamentoRepository telefoneEstacionamentoRepository;

	@Autowired
	EstacionamentoService estacionamentoService;

	@PostMapping
	@Transactional
	public RedirectView cadastrar(@RequestBody @Valid CadastroEstacionamentoForm form) {
		return estacionamentoService.cadastrar(form);
	}

	@GetMapping
	public ResponseEntity<?> listarTodosEstacionamentos() {
		return ResponseEntity.ok(EstacionamentoDto.converterTodosEstacionamentos(estacionamentoService.listarTodosEstacionamentos()));
	}

	@GetMapping("{id}")
	public ResponseEntity<?> listar(@PathVariable String id) {
		return ResponseEntity
				.ok(EstacionamentoDto.converter(estacionamentoService.verificarSeEstacionamentoExiste(id)));
	}
}
