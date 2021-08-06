package com.guilherme1550.apiestacionamento.service.validation.empresa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroEnderecoEmpresaHandler {
	
	@ExceptionHandler(EnderecoEmpresaNaoCadastradoException.class)
	public ResponseEntity<?> handle(EnderecoEmpresaNaoCadastradoException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(EnderecoEmpresaException.class)
	public ResponseEntity<?> handle(EnderecoEmpresaException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
}
