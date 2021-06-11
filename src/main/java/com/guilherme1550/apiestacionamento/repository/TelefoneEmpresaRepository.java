package com.guilherme1550.apiestacionamento.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme1550.apiestacionamento.model.TelefoneEmpresa;

public interface TelefoneEmpresaRepository extends JpaRepository<TelefoneEmpresa, UUID>{

}
