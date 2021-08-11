package com.guilherme1550.apiestacionamento.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.guilherme1550.apiestacionamento.model.Controle;

public interface ControleRepository extends JpaRepository<Controle, String> {
	List<Controle> findByVeiculoId(String idVeiculo);

	List<Controle> findByEnderecoEstacionamentoId(String idEstacionamento);

	@Query("SELECT c FROM Controle c where c.enderecoEstacionamento.id = :idEnderecoEstacionamento "
			+ "AND c.horaEntrada >= :horaInicio AND c.horaEntrada <= :horaFim")
	List<Controle> findByEnderecoEstacionamentoAndHora(String idEnderecoEstacionamento, LocalDateTime horaInicio,
			LocalDateTime horaFim);
}
