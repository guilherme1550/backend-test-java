package com.guilherme1550.apiestacionamento.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme1550.apiestacionamento.model.EnderecoEstacionamento;

public interface EnderecoEstacionamentoRepository extends JpaRepository<EnderecoEstacionamento, String>{

}
