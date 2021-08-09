package com.guilherme1550.apiestacionamento.service;

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
import com.guilherme1550.apiestacionamento.service.form.CadastroEstacionamentoForm;
import com.guilherme1550.apiestacionamento.service.validation.estacionamento.EstacionamentoException;

@Service
public class EstacionamentoService {
	
	@Autowired
	EstacionamentoRepository estacionamentoRepository;
	
	@Autowired
	EnderecoEstacionamentoRepository enderecoEstacionamentoRepository;
	
	@Autowired
	TelefoneEstacionamentoRepository telefoneEstacionamentoRepository;
	
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
			throw new EstacionamentoException("Nenhum estacionamento cadastrado!");
		}
		return estacionamentos;
	}
	
	public void deletar(String id) {
		estacionamentoRepository.delete(this.verificarSeEstacionamentoExiste(id));
	}
	
	public Estacionamento verificarSeEstacionamentoExiste(String idEstacionamento) {
		Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(idEstacionamento);
		if (estacionamento.isEmpty()) {
			throw new EstacionamentoException("Estacionamento não cadastrado!");
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
}
