package com.guilherme1550.apiestacionamento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme1550.apiestacionamento.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {
	Optional<Empresa> findByCnpj(String cnpj);
}
