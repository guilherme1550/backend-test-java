package com.guilherme1550.apiestacionamento.service.validation.estacionamento;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroEstacionamentoHandler {
	
	@ExceptionHandler(EstacionamentoException.class)
	public ResponseEntity<?> handle(EstacionamentoException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
}
