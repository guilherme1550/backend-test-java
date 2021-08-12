package com.guilherme1550.apiestacionamento.service.validation.autenticacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErroAutenticacaoHandler {
	
	@ExceptionHandler(AutenticacaoException.class)
	public ResponseEntity<?> handle(AutenticacaoException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
}
