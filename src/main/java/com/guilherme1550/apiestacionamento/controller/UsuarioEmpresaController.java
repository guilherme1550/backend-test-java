package com.guilherme1550.apiestacionamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme1550.apiestacionamento.controller.dto.TokenDto;
import com.guilherme1550.apiestacionamento.service.UsuarioEmpresaService;
import com.guilherme1550.apiestacionamento.service.form.LoginUsuarioEmpresaForm;

@RestController
@RequestMapping("/usuario-empresa")
public class UsuarioEmpresaController {
	
	@Autowired
	private UsuarioEmpresaService usuarioEmpresaService;

	@PostMapping("/auth")
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginUsuarioEmpresaForm form) {
		String token = usuarioEmpresaService.autenticar(form);
		return ResponseEntity.ok(new TokenDto(token, "Bearer"));
	}
}
