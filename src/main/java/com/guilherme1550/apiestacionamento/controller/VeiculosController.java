package com.guilherme1550.apiestacionamento.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme1550.apiestacionamento.controller.dto.VeiculoDto;
import com.guilherme1550.apiestacionamento.model.Veiculo;
import com.guilherme1550.apiestacionamento.repository.VeiculoRepository;
import com.guilherme1550.apiestacionamento.service.AutenticacaoUsuarioEmpresaService;
import com.guilherme1550.apiestacionamento.service.EnderecoEstacionamentoService;
import com.guilherme1550.apiestacionamento.service.VeiculoService;
import com.guilherme1550.apiestacionamento.service.form.AtualizaVeiculoDeEstacionamentoForm;
import com.guilherme1550.apiestacionamento.service.form.CadastroVeiculoForm;


@RestController
@RequestMapping("veiculos")
public class VeiculosController {
	
	@Autowired
	EnderecoEstacionamentoService enderecoEstacionamentoService;
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Autowired
	VeiculoService veiculoService;
	
	@Autowired
	AutenticacaoUsuarioEmpresaService autenticacaoUsuarioEmpresaService;
	
	@PostMapping
	public ResponseEntity<VeiculoDto> cadastrar(@RequestBody @Valid CadastroVeiculoForm form) {
		Veiculo veiculo = veiculoService.cadastrar(form);
		return ResponseEntity.status(HttpStatus.CREATED).body(VeiculoDto.converter(veiculo));
	}
	
	@GetMapping("/empresa")
	public ResponseEntity<List<VeiculoDto>> listarPorEmpresa() {
		List<Veiculo> veiculos = veiculoService.listarPorEmpresa();
		return ResponseEntity.ok(veiculos.stream().map(veiculo -> VeiculoDto.converter(veiculo)).collect(Collectors.toList()));
	}
	
	@PatchMapping("/atualizar-estacionamento")
	public ResponseEntity<VeiculoDto> atualizarEstacionamento(@RequestBody @Valid AtualizaVeiculoDeEstacionamentoForm form) {
		Veiculo veiculo = veiculoService.atualizarEstacionamento(form);
		return ResponseEntity.ok(VeiculoDto.converter(veiculo));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable String id) {
		veiculoService.remover(id);
		return ResponseEntity.ok("Veículo excluído com sucesso!");
	}
}
