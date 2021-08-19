package com.guilherme1550.apiestacionamento.controller;


import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme1550.apiestacionamento.controller.dto.EstacionamentoDto;
import com.guilherme1550.apiestacionamento.repository.EnderecoEstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.EstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.TelefoneEstacionamentoRepository;
import com.guilherme1550.apiestacionamento.service.EstacionamentoService;
import com.guilherme1550.apiestacionamento.service.form.AtualizaEstacionamentoForm;
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
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastroEstacionamentoForm form) {
		estacionamentoService.cadastrar(form);
//		return ResponseEntity.ok().build();
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<List<EstacionamentoDto>> listarTodosEstacionamentos() {
		return ResponseEntity.ok(EstacionamentoDto.converterTodosEstacionamentos(estacionamentoService.listarTodosEstacionamentos()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstacionamentoDto> listar(@PathVariable String id) {
		return ResponseEntity
				.ok(EstacionamentoDto.converter(estacionamentoService.verificarSeEstacionamentoExiste(id)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EstacionamentoDto> atualizar(@PathVariable String id, @RequestBody @Valid AtualizaEstacionamentoForm form) {
		return ResponseEntity.ok(EstacionamentoDto.converter(estacionamentoService.atualizar(id, form)));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletar(@PathVariable String id) {
		estacionamentoService.deletar(id);
		return ResponseEntity.ok("Estacionamento excluído com sucesso!");
	}
}
