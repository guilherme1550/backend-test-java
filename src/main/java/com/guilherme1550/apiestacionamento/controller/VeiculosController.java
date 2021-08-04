package com.guilherme1550.apiestacionamento.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.guilherme1550.apiestacionamento.service.AutenticacaoUsuarioEmpresaService;
import com.guilherme1550.apiestacionamento.service.EnderecoEstacionamentoService;
import com.guilherme1550.apiestacionamento.service.VeiculoService;
import com.guilherme1550.apiestacionamento.service.form.AtualizarVeiculoDeEstacionamentoForm;


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
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastroVeiculoForm form) {
		veiculoService.verificarSeVeiculoExiste(form.getPlaca());
		
		EnderecoEstacionamento enderecoEstacionamento = enderecoEstacionamentoService.verificarSeEnderecoEstacionamentoExiste(form.getIdEnderecoEstacionamento());
		if (enderecoEstacionamento == null)
			return ResponseEntity.badRequest().body("Endereço do estacionamento não encontrado");
		
		UsuarioEmpresa usuarioEmpresa = (UsuarioEmpresa) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Empresa empresa = usuarioEmpresa.getEmpresa();
		
		Veiculo veiculo = form.converterVeiculo(empresa, enderecoEstacionamento);
		enderecoEstacionamentoService.verificarSeEnderecoEstacionamentoPossuiVaga(enderecoEstacionamento, veiculo.getTipo());
		enderecoEstacionamentoService.subtrairVaga(enderecoEstacionamento, veiculo.getTipo());
		
		veiculoRepository.save(veiculo);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/empresa")
	public ResponseEntity<?> listarPorEmpresa() {
		Empresa empresa = autenticacaoUsuarioEmpresaService.getEmpresa();
		List<Veiculo> veiculos = veiculoRepository.findByEmpresaId(empresa.getId());
		if (veiculos.size() == 0)
			return ResponseEntity.notFound().build();
	
		return ResponseEntity.ok(veiculos);
	}
	
	@PatchMapping("/atualizar-estacionamento")
	@Transactional
	public ResponseEntity<?> atualizarEstacionamento(@RequestBody @Valid AtualizarVeiculoDeEstacionamentoForm form) {
		Veiculo veiculo = veiculoService.atualizarEstacionamento(form);
		return ResponseEntity.ok(veiculo);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable String id) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);
		if(veiculo.isPresent()) {
			veiculoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
