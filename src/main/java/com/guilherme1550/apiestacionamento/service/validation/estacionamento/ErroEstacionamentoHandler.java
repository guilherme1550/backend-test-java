package com.guilherme1550.apiestacionamento.service.validation.estacionamento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroEstacionamentoHandler {
	
	@ExceptionHandler(EstacionamentoException.class)
	public ResponseEntity<?> handle(EstacionamentoException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(EstacionamentoNaoCadastradoException.class)
	public ResponseEntity<?> handle(EstacionamentoNaoCadastradoException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
	
	@ExceptionHandler(NenhumEstacionamentoCadastradoException.class)
	public ResponseEntity<?> handle(NenhumEstacionamentoCadastradoException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
}
