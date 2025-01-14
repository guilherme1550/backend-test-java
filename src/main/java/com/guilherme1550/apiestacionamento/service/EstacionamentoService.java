package com.guilherme1550.apiestacionamento.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;
import com.guilherme1550.apiestacionamento.model.Estacionamento;
import com.guilherme1550.apiestacionamento.model.TelefoneEstacionamento;
import com.guilherme1550.apiestacionamento.repository.EnderecoEstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.EstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.TelefoneEstacionamentoRepository;
import com.guilherme1550.apiestacionamento.service.form.AtualizaEstacionamentoForm;
import com.guilherme1550.apiestacionamento.service.form.CadastroEstacionamentoForm;
import com.guilherme1550.apiestacionamento.service.validation.estacionamento.EnderecoEstacionamentoNaoCadastradoException;
import com.guilherme1550.apiestacionamento.service.validation.estacionamento.EstacionamentoException;
import com.guilherme1550.apiestacionamento.service.validation.estacionamento.EstacionamentoNaoCadastradoException;
import com.guilherme1550.apiestacionamento.service.validation.estacionamento.NenhumEstacionamentoCadastradoException;
import com.guilherme1550.apiestacionamento.service.validation.estacionamento.TelefoneEstacionamentoNaoCadastradoException;

@Service
public class EstacionamentoService {

	@Autowired
	EstacionamentoRepository estacionamentoRepository;

	@Autowired
	EnderecoEstacionamentoRepository enderecoEstacionamentoRepository;

	@Autowired
	TelefoneEstacionamentoRepository telefoneEstacionamentoRepository;

	@Autowired
	EnderecoEstacionamentoService enderecoEstacionamentoService;

	@Autowired
	TelefoneEstacionamentoService telefoneEstacionamentoService;

	@Transactional
	public RedirectView cadastrar(CadastroEstacionamentoForm form) {
		this.verificarSeEmailOuCnpjExiste(form.getEmail(), form.getCnpj());

		Estacionamento estacionamento = form.converterEstacionamento();
		Estacionamento estacionamentoCadastrado = estacionamentoRepository.save(estacionamento);

		List<EnderecoEstacionamento> enderecoEstacionamento = form.getEndereco().stream()
				.map(endereco -> endereco.converterEnderecoEstacionamento(estacionamentoCadastrado))
				.collect(Collectors.toList());
		enderecoEstacionamento.forEach(endereco -> enderecoEstacionamentoRepository.save(endereco));

		List<TelefoneEstacionamento> telefoneEstacionamento = form.getTelefone().stream()
				.map(telefone -> telefone.converterTelefoneEstacionamento(estacionamentoCadastrado))
				.collect(Collectors.toList());
		telefoneEstacionamento.forEach(telefone -> telefoneEstacionamentoRepository.save(telefone));

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://localhost:8080/estacionamentos/" + estacionamentoCadastrado.getId());
		return redirectView;
	}

	public List<Estacionamento> listarTodosEstacionamentos() {
		List<Estacionamento> estacionamentos = estacionamentoRepository.findAll();
		if (estacionamentos.size() == 0) {
			throw new NenhumEstacionamentoCadastradoException("Nenhum estacionamento cadastrado!");
		}
		return estacionamentos;
	}

	@Transactional
	public Estacionamento atualizar(String id, AtualizaEstacionamentoForm form) {

		// --- Validações e Atualizações ---
		
		Estacionamento estacionamento = this.verificarSeEstacionamentoExiste(id);
		estacionamento.setNome(form.getNome());

		List<EnderecoEstacionamento> enderecosEstacionamento = new ArrayList<>();
		form.getEndereco().forEach(endereco -> {
			EnderecoEstacionamento enderecoEstacionamento = enderecoEstacionamentoService
					.verificarSeEnderecoEstacionamentoExiste(endereco.getIdEnderecoEstacionamento());
			this.confirmarEndereco(id, enderecoEstacionamento);
			enderecoEstacionamento.setCep(endereco.getCep());
			enderecoEstacionamento.setUf(endereco.getUf());
			enderecoEstacionamento.setBairro(endereco.getBairro());
			enderecoEstacionamento.setLogradouro(endereco.getLogradouro());
			enderecoEstacionamento.setNumero(endereco.getNumero());
			enderecoEstacionamento.setComplemento(endereco.getComplemento());
			enderecoEstacionamento.setQtdVagasMoto(endereco.getQtdVagasMoto());
			enderecoEstacionamento.setQtdVagasCarro(endereco.getQtdVagasCarro());

			enderecosEstacionamento.add(enderecoEstacionamento);
		});

		List<TelefoneEstacionamento> telefonesEstacionamento = new ArrayList<>();
		form.getTelefone().forEach(telefone -> {
			TelefoneEstacionamento telefoneEstacionamento = telefoneEstacionamentoService
					.verificarSeTelefoneEstacionamentoExiste(telefone.getIdTelefoneEstacionamento());
			this.confirmarTelefone(id, telefoneEstacionamento);
			telefoneEstacionamento.setNumero(telefone.getNumero());
			
			telefonesEstacionamento.add(telefoneEstacionamento);
		});
		
		// --- Persistência ---
		
		estacionamentoRepository.save(estacionamento);
		enderecosEstacionamento.forEach(endereco -> enderecoEstacionamentoRepository.save(endereco));
		telefonesEstacionamento.forEach(telefone -> telefoneEstacionamentoRepository.save(telefone));

		// --- Retorno ---
		
		return estacionamento;
	}

	@Transactional
	public void deletar(String id) {
		estacionamentoRepository.delete(this.verificarSeEstacionamentoExiste(id));
	}

	public Estacionamento verificarSeEstacionamentoExiste(String idEstacionamento) {
		Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(idEstacionamento);
		if (estacionamento.isEmpty()) {
			throw new EstacionamentoNaoCadastradoException("Estacionamento não cadastrado!");
		}
		return estacionamento.get();
	}

	public void verificarSeEmailOuCnpjExiste(String email, String cnpj) {
		Optional<Estacionamento> emailExistenteEstacionamento = estacionamentoRepository.findByEmail(email);
		if (emailExistenteEstacionamento.isPresent())
			throw new EstacionamentoException("Email já cadastrado!");

		Optional<Estacionamento> cnpjExistenteEstacionamento = estacionamentoRepository.findByCnpj(cnpj);
		if (cnpjExistenteEstacionamento.isPresent())
			throw new EstacionamentoException("Cnpj já cadastrado!");
	}
	
	public void confirmarEndereco(String idEstacionamento, EnderecoEstacionamento enderecoEstacionamento) {
		if (!enderecoEstacionamento.getEstacionamento().getId().equals(idEstacionamento)) {
			throw new EnderecoEstacionamentoNaoCadastradoException("Este Estacionamento não possui este endereço!");
		}
	}
	
	public void confirmarTelefone(String idEstacionamento, TelefoneEstacionamento telefoneEstacionamento) {
		if (!telefoneEstacionamento.getEstacionamento().getId().equals(idEstacionamento)) {
			throw new TelefoneEstacionamentoNaoCadastradoException("Este Estacionamento não possui este telefone!");
		}
	}
}
