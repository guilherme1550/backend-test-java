package com.guilherme1550.apiestacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme1550.apiestacionamento.model.Controle;

public interface ControleRepository extends JpaRepository<Controle, String>{
	List<Controle> findByVeiculoId(String idVeiculo);
	List<Controle> findByEnderecoEstacionamentoId(String idEstacionamento);
}
