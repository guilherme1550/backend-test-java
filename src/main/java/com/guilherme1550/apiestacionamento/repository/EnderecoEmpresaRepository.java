package com.guilherme1550.apiestacionamento.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme1550.apiestacionamento.model.EnderecoEmpresa;

public interface EnderecoEmpresaRepository extends JpaRepository<EnderecoEmpresa, UUID> {

}
