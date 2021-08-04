package com.guilherme1550.apiestacionamento.service.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroControleHandler {

	@ExceptionHandler(ControleNaoEncontradoException.class)
	public ResponseEntity<?> handle(ControleNaoEncontradoException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(VeiculoNaoSeEncontraNoEstacionamentoException.class)
	public ResponseEntity<?> handle(VeiculoNaoSeEncontraNoEstacionamentoException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
}
