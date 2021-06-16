package com.guilherme1550.apiestacionamento.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme1550.apiestacionamento.controller.form.CadastroVeiculoForm;

@RestController
@RequestMapping("veiculos")
public class VeiculosController {
	
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastroVeiculoForm form) {
		return null;
	}
}