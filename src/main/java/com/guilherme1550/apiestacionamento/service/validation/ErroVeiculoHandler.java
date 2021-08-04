package com.guilherme1550.apiestacionamento.service.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroVeiculoHandler {

	@ExceptionHandler(TipoVeiculoException.class)
	public ResponseEntity<?> handle(TipoVeiculoException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(VeiculoJaCadastradoException.class)
	public ResponseEntity<?> handle(VeiculoJaCadastradoException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(VeiculoNaoCadastradoException.class)
	public ResponseEntity<?> handle(VeiculoNaoCadastradoException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(VeiculoJaCadastradoNoEstacionamentoException.class)
	public ResponseEntity<?> handle(VeiculoJaCadastradoNoEstacionamentoException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
}