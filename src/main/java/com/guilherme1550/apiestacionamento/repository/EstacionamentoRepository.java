package com.guilherme1550.apiestacionamento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme1550.apiestacionamento.model.Estacionamento;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, String> {

	Optional<Estacionamento> findByEmail(String email);
	
	Optional<Estacionamento> findByCnpj(String cnpj);
}
