package com.guilherme1550.apiestacionamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;
import com.guilherme1550.apiestacionamento.model.Veiculo;
import com.guilherme1550.apiestacionamento.repository.VeiculoRepository;
import com.guilherme1550.apiestacionamento.service.form.AtualizarVeiculoDeEstacionamentoForm;
import com.guilherme1550.apiestacionamento.service.validation.VeiculoJaCadastradoException;
import com.guilherme1550.apiestacionamento.service.validation.VeiculoJaCadastradoNoEstacionamentoException;
import com.guilherme1550.apiestacionamento.service.validation.VeiculoNaoCadastradoException;

@Service
public class VeiculoService {

	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Autowired
	EnderecoEstacionamentoService enderecoEstacionamentoService;
	
	
	public Veiculo atualizarEstacionamento(AtualizarVeiculoDeEstacionamentoForm form) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(form.getIdVeiculo());
		if(!veiculo.isPresent()) {
			throw new VeiculoNaoCadastradoException("Veiculo não cadastrado no sistema");
		}
		
		if(veiculo.get().getEnderecoEstacionamento().getId().equals(form.getIdEnderecoEstacionamento())) {
			throw new VeiculoJaCadastradoNoEstacionamentoException("O veículo já esta cadastrado neste estacionamento!");
		}
		
		EnderecoEstacionamento enderecoEstacionamento = enderecoEstacionamentoService.verificarSeEnderecoEstacionamentoExiste(form.getIdEnderecoEstacionamento());
		enderecoEstacionamentoService.verificarSeEnderecoEstacionamentoPossuiVaga(enderecoEstacionamento, veiculo.get().getTipo());
		enderecoEstacionamentoService.addVaga(veiculo.get().getEnderecoEstacionamento(), veiculo.get().getTipo());
		enderecoEstacionamentoService.subtrairVaga(enderecoEstacionamento, veiculo.get().getTipo());
		
		veiculo.get().setEnderecoEstacionamento(enderecoEstacionamento);
		Veiculo veiculoSalvo = veiculoRepository.save(veiculo.get());
		
		return veiculoSalvo;
	}
	
	
	public ResponseEntity<?> verificarSeVeiculoExiste(String placa) {
		Optional<Veiculo> veiculo = veiculoRepository.findByPlaca(placa);
		if (veiculo.isPresent())
			throw new VeiculoJaCadastradoException("Veículo já cadastrado no sistema.");
			
		return null;
	}
}
