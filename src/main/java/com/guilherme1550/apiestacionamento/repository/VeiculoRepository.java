package com.guilherme1550.apiestacionamento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme1550.apiestacionamento.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, String>{
	Optional<Veiculo> findByPlaca(String placa);
}
