package com.guilherme1550.apiestacionamento.service.validation.empresa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroTelefoneEmpresaHandler {
	
	@ExceptionHandler(TelefoneEmpresaNaoCadastradoException.class)
	public ResponseEntity<?> handle(TelefoneEmpresaNaoCadastradoException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(TelefoneEmpresaException.class)
	public ResponseEntity<?> handle(TelefoneEmpresaException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
}
