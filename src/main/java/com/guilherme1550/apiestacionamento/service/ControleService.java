package com.guilherme1550.apiestacionamento.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guilherme1550.apiestacionamento.model.Controle;
import com.guilherme1550.apiestacionamento.model.Veiculo;
import com.guilherme1550.apiestacionamento.repository.ControleRepository;
import com.guilherme1550.apiestacionamento.repository.VeiculoRepository;
import com.guilherme1550.apiestacionamento.service.form.EntradaVeiculoForm;
import com.guilherme1550.apiestacionamento.service.form.SaidaVeiculoForm;
import com.guilherme1550.apiestacionamento.service.validation.ControleNaoEncontradoException;
import com.guilherme1550.apiestacionamento.service.validation.VeiculoNaoCadastradoEnderecoEstacionamentoException;
import com.guilherme1550.apiestacionamento.service.validation.VeiculoNaoSeEncontraNoEstacionamentoException;

@Service
public class ControleService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private ControleRepository controleRepository;

	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private EnderecoEstacionamentoService enderecoEstacionamentoService;

	@Transactional
	public Controle entradaVeiculo(EntradaVeiculoForm form) {
		Veiculo veiculo = veiculoService.verificarCadastroVeiculoPorId(form.getIdVeiculo());
		enderecoEstacionamentoService.verificarSeEnderecoEstacionamentoExiste(form.getIdEnderecoEstacionamento());
		this.verificarSeVeiculoEstaNoLocalCerto(veiculo, form.getIdEnderecoEstacionamento());

		Controle controle = form.converter(veiculoRepository);
		Controle controleSalvo = controleRepository.save(controle);
		return controleSalvo;
	}
	
	@Transactional
	public Controle saidaVeiculo(SaidaVeiculoForm form) {
		Controle controle = this.verificarSeControleExiste(form.getIdControle());
		this.verificarSeVeiculoNaoSaiuDoEstacionamento(controle);
		controle.setHoraSaida(LocalDateTime.now());
		Controle controleSalvo = controleRepository.save(controle);
		return controleSalvo;
	}
	
	public List<Controle> listarPorPlacaVeiculo(String idPlacaVeiculo) {
		Veiculo veiculo = veiculoService.verificarCadastroVeiculoPorPlaca(idPlacaVeiculo);
		List<Controle> controles = controleRepository.findByVeiculoId(veiculo.getId());
		this.verificarSeListaControleExiste(controles);
		return controles;
	}
	
	public List<Controle> listarPorEnderecoEstacionamento(String idEnderecoEstacionamento) {
		enderecoEstacionamentoService.verificarSeEnderecoEstacionamentoExiste(idEnderecoEstacionamento);
		List<Controle> controles = controleRepository.findByEnderecoEstacionamentoId(idEnderecoEstacionamento);
		this.verificarSeListaControleExiste(controles);
		return controles;
	}
	
	public void verificarSeVeiculoNaoSaiuDoEstacionamento(Controle controle) {
		if (controle.getHoraSaida() != null)
			throw new VeiculoNaoSeEncontraNoEstacionamentoException(
					"Este veículo já realizou a saída do estacionamento!");
	}

	public void verificarSeVeiculoEstaNoLocalCerto(Veiculo veiculo, String idEnderecoEstacionamento) {
		if (!veiculo.getEnderecoEstacionamento().getId().equals(idEnderecoEstacionamento)) {
			throw new VeiculoNaoCadastradoEnderecoEstacionamentoException(
					"Veículo não está cadastrado neste Endereço de Estacionamento!");
		}
	}
	
	public Controle verificarSeControleExiste(String idControle) {
		Optional<Controle> controleOptional = controleRepository.findById(idControle);
		if(controleOptional.isEmpty()) {
			throw new ControleNaoEncontradoException("Controle não encontrado!");
		}
		return controleOptional.get();
	}
	
	public void verificarSeListaControleExiste(List<Controle> controles) {
		if(controles.size() == 0) {
			throw new ControleNaoEncontradoException("Nenhum controle encontrado!");
		}
	}
}
