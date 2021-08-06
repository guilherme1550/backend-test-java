package com.guilherme1550.apiestacionamento.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.guilherme1550.apiestacionamento.controller.dto.EmpresaDto;
import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.repository.EmpresaRepository;
import com.guilherme1550.apiestacionamento.service.EmpresaService;
import com.guilherme1550.apiestacionamento.service.form.AtualizaEmpresaForm;
import com.guilherme1550.apiestacionamento.service.form.CadastroEmpresaForm;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {

	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@PostMapping
	public RedirectView cadastrar(@RequestBody @Valid CadastroEmpresaForm form) {
		Empresa empresa = empresaService.cadastrar(form);

//		return ResponseEntity.created(URI.create("/empresas/" + empresa.getId())).build();
//		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("http://localhost:8080/empresas/" + empresa.getId())).build();
//		return new RedirectView().setUrl("http://localhost:8080/empresas/" + empresa.getId());
//		return ResponseEntity.
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://localhost:8080/empresas/" + empresa.getId());
		return redirectView;
	}

	@PutMapping("/{idEmpresa}")
	public ResponseEntity<?> atualizar(@RequestBody @Valid AtualizaEmpresaForm form, @PathVariable String idEmpresa) {
		Empresa empresa = empresaService.atualizar(form, idEmpresa);
		return ResponseEntity.ok(EmpresaDto.converter(empresa));
	}
	
	@GetMapping
	public ResponseEntity<?> listarTodasEmpresas() {
		List<Empresa> empresas = empresaRepository.findAll();
		List<EmpresaDto> empresaDto = new ArrayList<>();
		empresas.forEach(empresa -> empresaDto.add(EmpresaDto.converter(empresa)));
		
		return ResponseEntity.ok(empresaDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listar(@PathVariable String id) {
		return ResponseEntity.ok(EmpresaDto.converter(empresaService.verificarSeEmpresaExiste(id)));
	}
}
