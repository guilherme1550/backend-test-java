package com.guilherme1550.apiestacionamento.service.validation.estacionamento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroTelefoneEstacionamentoHandler {
	
	@ExceptionHandler(TelefoneEstacionamentoNaoCadastradoException.class)
	public ResponseEntity<?> handle(TelefoneEstacionamentoNaoCadastradoException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
}
