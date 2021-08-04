package com.guilherme1550.apiestacionamento.service.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroVagaEnderecoEstacionamentoHandler {

	@ExceptionHandler(VagasParaCarroInsuficienteException.class)
	public ResponseEntity<?> handle(VagasParaCarroInsuficienteException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(VagasParaMotoInsuficienteException.class)
	public ResponseEntity<?> handle(VagasParaMotoInsuficienteException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
}
