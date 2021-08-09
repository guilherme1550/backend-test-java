package com.guilherme1550.apiestacionamento.controller;



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
import com.guilherme1550.apiestacionamento.service.EmpresaService;
import com.guilherme1550.apiestacionamento.service.form.AtualizaEmpresaForm;
import com.guilherme1550.apiestacionamento.service.form.CadastroEmpresaForm;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {

	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping
	public RedirectView cadastrar(@RequestBody @Valid CadastroEmpresaForm form) {
		RedirectView redirectListarEmpresa = empresaService.cadastrar(form);
		return redirectListarEmpresa;
	}

	@PutMapping("/{idEmpresa}")
	public ResponseEntity<?> atualizar(@RequestBody @Valid AtualizaEmpresaForm form, @PathVariable String idEmpresa) {
		Empresa empresa = empresaService.atualizar(form, idEmpresa);
		return ResponseEntity.ok(EmpresaDto.converter(empresa));
	}
	
	@GetMapping
	public ResponseEntity<?> listarTodasEmpresas() {
		List<Empresa> empresas = empresaService.listarTodasEmpresas();
		return ResponseEntity.ok(EmpresaDto.converterTodasEmpresas(empresas));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listar(@PathVariable String id) {
		return ResponseEntity.ok(EmpresaDto.converter(empresaService.verificarSeEmpresaExiste(id)));
	}
}
