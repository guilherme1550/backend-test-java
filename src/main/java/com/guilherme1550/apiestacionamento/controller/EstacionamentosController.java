package com.guilherme1550.apiestacionamento.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme1550.apiestacionamento.controller.form.CadastroEstacionamentoForm;
import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;
import com.guilherme1550.apiestacionamento.model.Estacionamento;
import com.guilherme1550.apiestacionamento.model.TelefoneEstacionamento;
import com.guilherme1550.apiestacionamento.repository.EnderecoEstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.EstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.TelefoneEstacionamentoRepository;
import com.guilherme1550.apiestacionamento.service.EstacionamentoService;

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
		
		String mensagem = estacionamentoService.verificarSeEmailOuCnpjExiste(form.getEmail(), form.getCnpj());
		if (mensagem != null)
			return ResponseEntity.badRequest().body(mensagem);
		
		Estacionamento estacionamento = form.converterEstacionamento();
		Estacionamento estacionamentoCadastrado = estacionamentoRepository.save(estacionamento);

		List<EnderecoEstacionamento> enderecoEstacionamento = form.getEndereco().stream()
				.map(endereco -> endereco.converterEnderecoEstacionamento(estacionamentoCadastrado))
				.collect(Collectors.toList());
		enderecoEstacionamento.forEach(endereco -> enderecoEstacionamentoRepository.save(endereco));

		List<TelefoneEstacionamento> telefoneEstacionamento = form.getTelefone().stream()
				.map(telefone -> telefone.converterTelefoneEstacionamento(estacionamentoCadastrado))
				.collect(Collectors.toList());
		telefoneEstacionamento.forEach(telefone -> telefoneEstacionamentoRepository.save(telefone));

		return ResponseEntity.ok().build();
	}
}
