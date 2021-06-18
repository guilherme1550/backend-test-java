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

import com.guilherme1550.apiestacionamento.controller.form.CadastroEmpresaForm;
import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.EnderecoEmpresa;
import com.guilherme1550.apiestacionamento.model.TelefoneEmpresa;
import com.guilherme1550.apiestacionamento.model.UsuarioEmpresa;
import com.guilherme1550.apiestacionamento.repository.EmpresaRepository;
import com.guilherme1550.apiestacionamento.repository.EnderecoEmpresaRepository;
import com.guilherme1550.apiestacionamento.repository.TelefoneEmpresaRepository;
import com.guilherme1550.apiestacionamento.repository.UsuarioEmpresaRepository;
import com.guilherme1550.apiestacionamento.service.EmpresaService;
import com.guilherme1550.apiestacionamento.service.PerfilService;
import com.guilherme1550.apiestacionamento.service.UsuarioService;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private EnderecoEmpresaRepository enderecoEmpresaRepository;
	
	@Autowired
	private TelefoneEmpresaRepository telefoneEmpresaRepository;
	
	@Autowired
	private UsuarioEmpresaRepository usuarioRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PerfilService perfilService;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastroEmpresaForm form) {
		
		String mensagem = empresaService.verificarSeCnpjExiste(form.getCnpj());
		if (mensagem != null) 
			return ResponseEntity.badRequest().body(mensagem);
		
		mensagem = usuarioService.verificarSeEmailExiste(form.getUsuario().getEmail());
		if (mensagem != null)
			return ResponseEntity.badRequest().body(mensagem);
		
		
		Empresa empresa = form.converterEmpresa();
		Empresa empresaCadastrada = empresaRepository.save(empresa);

		List<EnderecoEmpresa> enderecoEmpresa = form.getEndereco().stream()
				.map(endereco -> endereco.converterEnderecoEmpresa(empresaCadastrada)).collect(Collectors.toList());
		enderecoEmpresa.forEach(endereco -> enderecoEmpresaRepository.save(endereco));
		
		List<TelefoneEmpresa> telefoneEmpresa = form.getTelefone().stream()
				.map(telefone -> telefone.converterTelefoneEmpresa(empresaCadastrada)).collect(Collectors.toList());
		telefoneEmpresa.forEach(telefone -> telefoneEmpresaRepository.save(telefone));
		
		UsuarioEmpresa usuario = form.getUsuario().converterUsuario(empresaCadastrada, perfilService);
		usuarioRepository.save(usuario);
		
		return ResponseEntity.ok().build();
	}
}
