package com.guilherme1550.apiestacionamento.service.validation.veiculo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.guilherme1550.apiestacionamento.service.validation.controle.VeiculoNaoCadastradoEnderecoEstacionamentoException;

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
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
	
	@ExceptionHandler(VeiculoJaCadastradoNoEstacionamentoException.class)
	public ResponseEntity<?> handle(VeiculoJaCadastradoNoEstacionamentoException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(VeiculoNaoCadastradoEnderecoEstacionamentoException.class)
	public ResponseEntity<?> handle(VeiculoNaoCadastradoEnderecoEstacionamentoException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
	
}
