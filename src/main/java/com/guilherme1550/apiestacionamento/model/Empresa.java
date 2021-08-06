package com.guilherme1550.apiestacionamento.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Empresa {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column(name = "nome", updatable = true, nullable = false)
	private String nome;
	
	@Column(name = "cnpj", updatable = true, nullable = false)
	private String cnpj;
	
	@OneToMany(mappedBy = "empresa")
	private List<EnderecoEmpresa> enderecoEmpresa;
	
	@OneToMany(mappedBy = "empresa")
	private List<TelefoneEmpresa> telefoneEmpresa;
	
	@OneToMany(mappedBy = "empresa")
	private List<UsuarioEmpresa> usuarioEmpresa;
	
	public Empresa() {}
	
	public Empresa(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public List<EnderecoEmpresa> getEnderecoEmpresa() {
		return enderecoEmpresa;
	}

	public void setEnderecoEmpresa(List<EnderecoEmpresa> enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}

	public List<TelefoneEmpresa> getTelefoneEmpresa() {
		return telefoneEmpresa;
	}

	public void setTelefoneEmpresa(List<TelefoneEmpresa> telefoneEmpresa) {
		this.telefoneEmpresa = telefoneEmpresa;
	}

	public List<UsuarioEmpresa> getUsuarioEmpresa() {
		return usuarioEmpresa;
	}

	public void setUsuarioEmpresa(List<UsuarioEmpresa> usuarioEmpresa) {
		this.usuarioEmpresa = usuarioEmpresa;
	}

}
