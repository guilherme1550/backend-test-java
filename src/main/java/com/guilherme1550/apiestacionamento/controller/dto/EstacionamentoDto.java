package com.guilherme1550.apiestacionamento.controller.dto;


import java.util.List;
import java.util.stream.Collectors;

import com.guilherme1550.apiestacionamento.model.Estacionamento;

public class EstacionamentoDto {
	private String id;
	private String nome;
	private String cnpj;
	private String email;
	private List<EnderecoEstacionamentoDto> enderecoEstacionamento;
	private List<TelefoneEstacionamentoDto> telefoneEstacionamento;

	public EstacionamentoDto(Estacionamento estacionamento, List<EnderecoEstacionamentoDto> enderecoEstacionamentoDto, List<TelefoneEstacionamentoDto> telefoneEstacionamentoDto) {
		this.id = estacionamento.getId();
		this.nome = estacionamento.getNome();
		this.cnpj = estacionamento.getCnpj();
		this.email = estacionamento.getEmail();
		this.enderecoEstacionamento = enderecoEstacionamentoDto;
		this.telefoneEstacionamento = telefoneEstacionamentoDto;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getEmail() {
		return email;
	}

	public List<EnderecoEstacionamentoDto> getEnderecoEstacionamento() {
		return enderecoEstacionamento;
	}

	public List<TelefoneEstacionamentoDto> getTelefoneEstacionamento() {
		return telefoneEstacionamento;
	}

	public static EstacionamentoDto converter(Estacionamento estacionamento) {
		List<EnderecoEstacionamentoDto> enderecoEstacionamentoDto = estacionamento.getEnderecoEstacionamento().stream()
				.map(endereco -> new EnderecoEstacionamentoDto(endereco)).collect(Collectors.toList());
		
		List<TelefoneEstacionamentoDto> telefoneEstacionamentoDto = estacionamento.getTelefoneEstacionamento().stream()
				.map(telefone -> new TelefoneEstacionamentoDto(telefone)).collect(Collectors.toList());
		
		return new EstacionamentoDto(estacionamento, enderecoEstacionamentoDto, telefoneEstacionamentoDto);
	}

}
