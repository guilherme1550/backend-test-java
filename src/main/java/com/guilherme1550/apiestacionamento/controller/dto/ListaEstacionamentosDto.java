package com.guilherme1550.apiestacionamento.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;
import com.guilherme1550.apiestacionamento.model.Estacionamento;
import com.guilherme1550.apiestacionamento.model.TelefoneEstacionamento;

public class ListaEstacionamentosDto {
	private String id;
	private String nome;
	private String cnpj;
	private String email;
	private List<EnderecoEstacionamento> enderecoEstacionamento;
	private List<TelefoneEstacionamento> telefoneEstacionamento;

	public ListaEstacionamentosDto(Estacionamento estacionamento) {
		this.id = estacionamento.getId();
		this.nome = estacionamento.getNome();
		this.cnpj = estacionamento.getCnpj();
		this.email = estacionamento.getEmail();
		this.enderecoEstacionamento = estacionamento.getEnderecoEstacionamento();
		this.telefoneEstacionamento = estacionamento.getTelefoneEstacionamento();
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

	public List<EnderecoEstacionamento> getEnderecoEstacionamento() {
		return enderecoEstacionamento;
	}

	public List<TelefoneEstacionamento> getTelefoneEstacionamento() {
		return telefoneEstacionamento;
	}
	
	public static List<ListaEstacionamentosDto> converter(List<Estacionamento> estacionamentos) {
		List<ListaEstacionamentosDto> estacionamentosDto = new ArrayList<>();
		estacionamentos.forEach(estacionamento -> estacionamentosDto.add(new ListaEstacionamentosDto(estacionamento)));
		
		return estacionamentosDto;
	}
	
}
