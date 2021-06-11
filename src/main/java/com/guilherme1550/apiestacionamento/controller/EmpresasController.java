package com.guilherme1550.apiestacionamento.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme1550.apiestacionamento.controller.form.CadastroEmpresaForm;
import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.EnderecoEmpresa;
import com.guilherme1550.apiestacionamento.model.TelefoneEmpresa;
import com.guilherme1550.apiestacionamento.repository.EmpresaRepository;
import com.guilherme1550.apiestacionamento.repository.EnderecoEmpresaRepository;
import com.guilherme1550.apiestacionamento.repository.TelefoneEmpresaRepository;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private EnderecoEmpresaRepository enderecoEmpresaRepository;
	
	@Autowired
	private TelefoneEmpresaRepository telefoneEmpresaRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody CadastroEmpresaForm form) {
		Empresa empresa = form.converterEmpresa();
		Empresa empresaCadastrada = empresaRepository.save(empresa);

		List<EnderecoEmpresa> enderecoEmpresa = form.getEndereco().stream()
				.map(endereco -> endereco.converterEnderecoEmpresa(empresaCadastrada)).collect(Collectors.toList());
		enderecoEmpresa.forEach(endereco -> enderecoEmpresaRepository.save(endereco));
		
		List<TelefoneEmpresa> telefoneEmpresa = form.getTelefone().stream()
				.map(telefone -> telefone.converterTelefoneEmpresa(empresaCadastrada)).collect(Collectors.toList());
		telefoneEmpresa.forEach(telefone -> telefoneEmpresaRepository.save(telefone));

		return ResponseEntity.ok().build();
	}
}
