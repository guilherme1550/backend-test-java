package com.guilherme1550.apiestacionamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme1550.apiestacionamento.controller.form.CadastroVeiculoForm;
import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;
import com.guilherme1550.apiestacionamento.model.UsuarioEmpresa;
import com.guilherme1550.apiestacionamento.model.Veiculo;
import com.guilherme1550.apiestacionamento.repository.VeiculoRepository;
import com.guilherme1550.apiestacionamento.service.EnderecoEstacionamentoService;
import com.guilherme1550.apiestacionamento.service.VeiculoService;

@RestController
@RequestMapping("veiculos")
public class VeiculosController {
	
	@Autowired
	EnderecoEstacionamentoService enderecoEstacionamentoService;
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Autowired
	VeiculoService veiculoService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastroVeiculoForm form) {
		veiculoService.verificarSeVeiculoExiste(form.getPlaca());
		
		EnderecoEstacionamento enderecoEstacionamento = enderecoEstacionamentoService.verificarSeEnderecoEstacionamentoExiste(form.getIdEnderecoEstacionamento());
		if (enderecoEstacionamento == null)
			return ResponseEntity.badRequest().body("Endereço do estacionamento não encontrado");
		
		enderecoEstacionamentoService.verificarSeEnderecoEstacionamentoPossuiVaga(enderecoEstacionamento, form.getTipo());
		enderecoEstacionamentoService.subtrairVaga(enderecoEstacionamento, form.getTipo());
		
		UsuarioEmpresa usuarioEmpresa = (UsuarioEmpresa) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Empresa empresa = usuarioEmpresa.getEmpresa();
		
		Veiculo veiculo = form.converterVeiculo(empresa, enderecoEstacionamento);
		veiculoRepository.save(veiculo);
		
		return ResponseEntity.ok().build();
	}
}
