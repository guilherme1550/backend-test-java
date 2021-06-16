package com.guilherme1550.apiestacionamento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme1550.apiestacionamento.model.UsuarioEmpresa;

public interface UsuarioEmpresaRepository extends JpaRepository<UsuarioEmpresa, String> {
	Optional<UsuarioEmpresa> findByEmail(String email);
}
