package com.guilherme1550.apiestacionamento.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Estacionamento {
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "nome", updatable = true, nullable = false)
	private String nome;
	
	@Column(name = "cnpj", updatable = true, nullable = false)
	private String cnpj;
	
	@Column(name = "endereco", updatable = true, nullable = false)
	private String endereco;
	
	@Column(name = "telefone", updatable = true, nullable = false)
	private String telefone;
	
	@Column(name = "qtd_vagas_moto", updatable = true, nullable = false)
	private int qtdVagasMoto;
	
	@Column(name = "qtd_vagas_carro", updatable = true, nullable = false)
	private int qtdVagasCarro;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getQtdVagasMoto() {
		return qtdVagasMoto;
	}

	public void setQtdVagasMoto(int qtdVagasMoto) {
		this.qtdVagasMoto = qtdVagasMoto;
	}

	public int getQtdVagasCarro() {
		return qtdVagasCarro;
	}

	public void setQtdVagasCarro(int qtdVagasCarro) {
		this.qtdVagasCarro = qtdVagasCarro;
	}

}
