package com.guilherme1550.apiestacionamento.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;
import com.guilherme1550.apiestacionamento.model.Veiculo;
import com.guilherme1550.apiestacionamento.repository.VeiculoRepository;
import com.guilherme1550.apiestacionamento.service.form.AtualizaVeiculoDeEstacionamentoForm;
import com.guilherme1550.apiestacionamento.service.form.CadastroVeiculoForm;
import com.guilherme1550.apiestacionamento.service.validation.veiculo.VeiculoJaCadastradoException;
import com.guilherme1550.apiestacionamento.service.validation.veiculo.VeiculoJaCadastradoNoEstacionamentoException;
import com.guilherme1550.apiestacionamento.service.validation.veiculo.VeiculoNaoCadastradoException;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private EnderecoEstacionamentoService enderecoEstacionamentoService;
	
	@Autowired
	private AutenticacaoUsuarioEmpresaService autenticacaoUsuarioEmpresaService;

	@Transactional
	public Veiculo cadastrar(CadastroVeiculoForm form) {
		this.verificarSeVeiculoExiste(form.getPlaca());

		EnderecoEstacionamento enderecoEstacionamento = enderecoEstacionamentoService
				.verificarSeEnderecoEstacionamentoExiste(form.getIdEnderecoEstacionamento());

		Empresa empresa = autenticacaoUsuarioEmpresaService.getEmpresa();

		Veiculo veiculo = form.converterVeiculo(empresa, enderecoEstacionamento);

		enderecoEstacionamentoService.verificarSeEnderecoEstacionamentoPossuiVaga(enderecoEstacionamento,
				veiculo.getTipo());
		enderecoEstacionamentoService.subtrairVaga(enderecoEstacionamento, veiculo.getTipo());

		Veiculo veiculoSalvo = veiculoRepository.save(veiculo);
		return veiculoSalvo;
	}

	public List<Veiculo> listarPorEmpresa() {
		Empresa empresa = autenticacaoUsuarioEmpresaService.getEmpresa();
		List<Veiculo> veiculos = veiculoRepository.findByEmpresaId(empresa.getId());
		if (veiculos.size() == 0)
			throw new VeiculoNaoCadastradoException("Nenhum veículo encontrado!");
	
		return veiculos;
	}
	
	@Transactional
	public Veiculo atualizarEstacionamento(AtualizaVeiculoDeEstacionamentoForm form) {
		Veiculo veiculo = this.verificarCadastroVeiculoPorId(form.getIdVeiculo());

		if (veiculo.getEnderecoEstacionamento().getId().equals(form.getIdEnderecoEstacionamento())) {
			throw new VeiculoJaCadastradoNoEstacionamentoException(
					"O veículo já esta cadastrado neste estacionamento!");
		}

		EnderecoEstacionamento enderecoEstacionamento = enderecoEstacionamentoService
				.verificarSeEnderecoEstacionamentoExiste(form.getIdEnderecoEstacionamento());
		enderecoEstacionamentoService.verificarSeEnderecoEstacionamentoPossuiVaga(enderecoEstacionamento,
				veiculo.getTipo());
		enderecoEstacionamentoService.addVaga(veiculo.getEnderecoEstacionamento(), veiculo.getTipo());
		enderecoEstacionamentoService.subtrairVaga(enderecoEstacionamento, veiculo.getTipo());

		veiculo.setEnderecoEstacionamento(enderecoEstacionamento);
		Veiculo veiculoSalvo = veiculoRepository.save(veiculo);

		return veiculoSalvo;
	}
	
	@Transactional
	public void remover(String id) {
		Veiculo veiculo = this.verificarCadastroVeiculoPorId(id);
		enderecoEstacionamentoService.addVaga(veiculo.getEnderecoEstacionamento(), veiculo.getTipo());
		veiculoRepository.deleteById(id);
	}

	public void verificarSeVeiculoExiste(String placa) {
		Optional<Veiculo> veiculo = veiculoRepository.findByPlaca(placa);
		if (veiculo.isPresent())
			throw new VeiculoJaCadastradoException("Veículo já cadastrado no sistema!");
	}
	
	public Veiculo verificarCadastroVeiculoPorId(String idVeiculo) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(idVeiculo);
		if(veiculo.isEmpty()) {
			throw new VeiculoNaoCadastradoException("Veículo não cadastrado no sistema!");
		}
		return veiculo.get();
	}
	
	public Veiculo verificarCadastroVeiculoPorPlaca(String placa) {
		Optional<Veiculo> veiculo = veiculoRepository.findByPlaca(placa);
		if(veiculo.isEmpty()) {
			throw new VeiculoNaoCadastradoException("Veículo não cadastrado no sistema!");
		}
		return veiculo.get();
	}
}
