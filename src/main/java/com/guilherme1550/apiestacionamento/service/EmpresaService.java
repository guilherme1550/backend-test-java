package com.guilherme1550.apiestacionamento.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.guilherme1550.apiestacionamento.model.Empresa;
import com.guilherme1550.apiestacionamento.model.EnderecoEmpresa;
import com.guilherme1550.apiestacionamento.model.TelefoneEmpresa;
import com.guilherme1550.apiestacionamento.model.UsuarioEmpresa;
import com.guilherme1550.apiestacionamento.repository.EmpresaRepository;
import com.guilherme1550.apiestacionamento.repository.EnderecoEmpresaRepository;
import com.guilherme1550.apiestacionamento.repository.TelefoneEmpresaRepository;
import com.guilherme1550.apiestacionamento.repository.UsuarioEmpresaRepository;
import com.guilherme1550.apiestacionamento.service.form.AtualizaEmpresaForm;
import com.guilherme1550.apiestacionamento.service.form.CadastroEmpresaForm;
import com.guilherme1550.apiestacionamento.service.validation.empresa.CnpjExistenteException;
import com.guilherme1550.apiestacionamento.service.validation.empresa.EmpresaNaoCadastradaException;
import com.guilherme1550.apiestacionamento.service.validation.empresa.EnderecoEmpresaException;
import com.guilherme1550.apiestacionamento.service.validation.empresa.TelefoneEmpresaException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private EnderecoEmpresaRepository enderecoEmpresaRepository;

	@Autowired
	private TelefoneEmpresaRepository telefoneEmpresaRepository;

	@Autowired
	private UsuarioEmpresaRepository usuarioEmpresaRepository;
	
	@Autowired
	private EnderecoEmpresaService enderecoEmpresaService;

	@Autowired
	private TelefoneEmpresaService telefoneEmpresaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PerfilService perfilService;

	
	@javax.transaction.Transactional
	public Empresa cadastrar(CadastroEmpresaForm form) {
		this.verificarSeCnpjExiste(null);
		form.getUsuario().forEach(usuario -> usuarioService.verificarSeEmailExiste(usuario.getEmail()));
		
		Empresa empresa = form.converterEmpresa();
		Empresa empresaCadastrada = empresaRepository.save(empresa);
		
		List<EnderecoEmpresa> enderecoEmpresa = form.getEndereco().stream()
				.map(endereco -> endereco.converterEnderecoEmpresa(empresaCadastrada)).collect(Collectors.toList());
		enderecoEmpresa.forEach(endereco -> enderecoEmpresaRepository.save(endereco));
		
		List<TelefoneEmpresa> telefoneEmpresa = form.getTelefone().stream()
				.map(telefone -> telefone.converterTelefoneEmpresa(empresaCadastrada)).collect(Collectors.toList());
		telefoneEmpresa.forEach(telefone -> telefoneEmpresaRepository.save(telefone));
		
		List<UsuarioEmpresa> usuarioEmpresa = form.getUsuario().stream()
				.map(usuario -> usuario.converterUsuario(empresaCadastrada, perfilService)).collect(Collectors.toList());
		usuarioEmpresa.forEach(usuario -> usuarioEmpresaRepository.save(usuario));
		
		
		return empresaCadastrada;
	}

	public Empresa atualizar(AtualizaEmpresaForm form, String idEmpresa) {

		// --- Validações ---

		Empresa empresa = this.verificarSeEmpresaExiste(idEmpresa);
		form.getEndereco().forEach(endereco -> {
			EnderecoEmpresa enderecoEmpresa = enderecoEmpresaService
					.verificarSeEnderecoEmpresaExiste(endereco.getIdEnderecoEmpresa());
			this.confirmarEndereco(idEmpresa, enderecoEmpresa);
		});
		form.getTelefone().forEach(telefone -> {
			TelefoneEmpresa telefoneEmpresa = telefoneEmpresaService
					.verificarSeTelefoneEmpresaExiste(telefone.getIdTelefoneEmpresa());
			this.confirmarTelefone(idEmpresa, telefoneEmpresa);
		});

		// --- Atualização e persistência ---

		empresa.setNome(form.getNome());
		Empresa empresaSalva = empresaRepository.save(empresa);

		form.getEndereco().forEach(endereco -> {
			Optional<EnderecoEmpresa> enderecoEmpresa = enderecoEmpresaRepository
					.findById(endereco.getIdEnderecoEmpresa());
			enderecoEmpresa.get().setCep(endereco.getCep());
			enderecoEmpresa.get().setUf(endereco.getUf());
			enderecoEmpresa.get().setBairro(endereco.getBairro());
			enderecoEmpresa.get().setLogradouro(endereco.getLogradouro());
			enderecoEmpresa.get().setNumero(endereco.getNumero());
			enderecoEmpresa.get().setComplemento(endereco.getComplemento());

			enderecoEmpresaRepository.save(enderecoEmpresa.get());
		});

		form.getTelefone().forEach(telefone -> {
			Optional<TelefoneEmpresa> telefoneEmpresa = telefoneEmpresaRepository
					.findById(telefone.getIdTelefoneEmpresa());
			telefoneEmpresa.get().setNumero(telefone.getNumero());

			telefoneEmpresaRepository.save(telefoneEmpresa.get());
		});

		return empresaSalva;
	}

	public Empresa verificarSeEmpresaExiste(String idEmpresa) {
		Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
		if (empresa.isEmpty()) {
			throw new EmpresaNaoCadastradaException("Empresa não cadastrada!");
		}
		return empresa.get();
	}

	public void verificarSeCnpjExiste(String cnpj) {
		Optional<Empresa> empresa = empresaRepository.findByCnpj(cnpj);

		if (empresa.isPresent()) {
			throw new CnpjExistenteException("CNPJ já cadastrado!");
		}
	}
	
	public void confirmarEndereco(String idEmpresa, EnderecoEmpresa enderecoEmpresa) {
		if (!enderecoEmpresa.getEmpresa().getId().equals(idEmpresa)) {
			throw new EnderecoEmpresaException("Esta Empresa não possui este endereço!");
		}
	}

	public void confirmarTelefone(String idEmpresa, TelefoneEmpresa telefoneEmpresa) {
		if (!telefoneEmpresa.getEmpresa().getId().equals(idEmpresa)) {
			throw new TelefoneEmpresaException("Esta Empresa não possui este telefone!");
		}
	}

}
