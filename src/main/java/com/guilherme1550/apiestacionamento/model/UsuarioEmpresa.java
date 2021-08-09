package com.guilherme1550.apiestacionamento.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class UsuarioEmpresa implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column(name = "email", updatable = true, nullable = false)
	private String email;
	
	@Column(name = "senha", updatable = true, nullable = false)
	private String senha;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Perfil> perfil = new ArrayList<>();
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Empresa empresa;
	
	public UsuarioEmpresa() {}
	
	public UsuarioEmpresa(String email, String senha, List<Perfil> perfil, Empresa empresa) {
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
		this.empresa = empresa;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Perfil> getPerfil() {
		return perfil;
	}

	public void setPerfis(List<Perfil> perfil) {
		this.perfil = perfil;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfil;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
