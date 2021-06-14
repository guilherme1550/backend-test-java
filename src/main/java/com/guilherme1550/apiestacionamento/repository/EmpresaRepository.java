package com.guilherme1550.apiestacionamento.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme1550.apiestacionamento.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, UUID> {
	Optional<Empresa> findByCnpj(String cnpj);
}
