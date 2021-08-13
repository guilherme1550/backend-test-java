package com.guilherme1550.apiestacionamento.service.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizaEnderecoEstacionamentoForm {
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Id do Endereço do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Id do Endereço do Estacionamento")
	private String idEnderecoEstacionamento;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Cep do Endereço do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Cep do Endereço do Estacionamento")
	private String cep;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o UF do Endereço do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o UF do Endereço do Estacionamento")
	private String uf;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Bairro do Endereço do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Bairro do Endereço do Estacionamento")
	private String bairro;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Logradouro do Endereço do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Logradouro do Endereço do Estacionamento")
	private String logradouro;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Numero do Endereço do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Numero do Endereço do Estacionamento")
	private String numero;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar o Complemento do Endereço do Estacionamento")
	@NotEmpty(message = "O campo não pode ser vazio, favor digitar o Complemento do Endereço do Estacionamento")
	private String complemento;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar a Quantidade de Vagas para Moto")
	@Min(value=0)
	private Integer qtdVagasMoto;
	
	@NotNull(message = "O campo não pode ser nulo, favor digitar a Quantidade de Vagas para Carro")
	@Min(value=0)
	private Integer qtdVagasCarro;
	
	
	public String getIdEnderecoEstacionamento() {
		return idEnderecoEstacionamento;
	}
	public void setIdEnderecoEstacionamento(String id) {
		this.idEnderecoEstacionamento = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Integer getQtdVagasMoto() {
		return qtdVagasMoto;
	}
	public void setQtdVagasMoto(Integer qtdVagasMoto) {
		this.qtdVagasMoto = qtdVagasMoto;
	}
	public Integer getQtdVagasCarro() {
		return qtdVagasCarro;
	}
	public void setQtdVagasCarro(Integer qtdVagasCarro) {
		this.qtdVagasCarro = qtdVagasCarro;
	}
	
}
