package com.guilherme1550.apiestacionamento.service.validation.empresa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErroEmpresaHandler {

	@ExceptionHandler(EmpresaNaoCadastradaException.class)
	public ResponseEntity<?> handle(EmpresaNaoCadastradaException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(CnpjExistenteException.class)
	public ResponseEntity<?> handle(CnpjExistenteException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(EmailExistenteException.class)
	public ResponseEntity<?> handle(EmailExistenteException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(EmpresaException.class)
	public ResponseEntity<?> handle(EmpresaException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	
}
