package com.guilherme1550.apiestacionamento.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class EnderecoEstacionamento {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

	@Column(name = "cep", updatable = true, nullable = false)
	private String cep;

	@Column(name = "uf", updatable = true, nullable = false)
	private String uf;

	@Column(name = "bairro", updatable = true, nullable = false)
	private String bairro;

	@Column(name = "logradouro", updatable = true, nullable = false)
	private String logradouro;

	@Column(name = "numero", updatable = true, nullable = false)
	private String numero;

	@Column(name = "complemento", updatable = true, nullable = false)
	private String complemento;

	@Column(name = "qtd_vagas_moto", updatable = true, nullable = false)
	private Integer qtdVagasMoto;

	@Column(name = "qtd_vagas_carro", updatable = true, nullable = false)
	private Integer qtdVagasCarro;

	@ManyToOne()
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Estacionamento estacionamento;

	public EnderecoEstacionamento() {
	}

	public EnderecoEstacionamento(String cep, String uf, String bairro, String logradouro, String numero,
			String complemento, Integer qtdVagasMoto, Integer qtdVagasCarro, Estacionamento estacionamento) {
		this.cep = cep;
		this.uf = uf;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.qtdVagasMoto = qtdVagasMoto;
		this.qtdVagasCarro = qtdVagasCarro;
		this.estacionamento = estacionamento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

}
