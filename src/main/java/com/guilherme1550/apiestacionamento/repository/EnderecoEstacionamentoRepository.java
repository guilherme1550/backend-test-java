package com.guilherme1550.apiestacionamento.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;

public interface EnderecoEstacionamentoRepository extends JpaRepository<EnderecoEstacionamento, String>{
	
	@Query(value = "SELECT ESTACIONAMENTO_ID from ENDERECO_ESTACIONAMENTO e where e.id = :idEnderecoEstacionamento", nativeQuery = true)
	public String getIdEstacionamento(String idEnderecoEstacionamento);
}
