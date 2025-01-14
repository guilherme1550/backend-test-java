package com.guilherme1550.apiestacionamento.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Controle {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column(name = "hora_entrada", updatable = true, nullable = false)
	private LocalDateTime horaEntrada;
	@Column(name = "hora_saida", updatable = true, nullable = true)
	private LocalDateTime horaSaida;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Veiculo veiculo;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EnderecoEstacionamento enderecoEstacionamento;

	public Controle() {}
	
	public Controle(Veiculo veiculo) {
		this.horaEntrada = LocalDateTime.now();
		this.veiculo = veiculo;
		this.enderecoEstacionamento = veiculo.getEnderecoEstacionamento();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDateTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalDateTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public EnderecoEstacionamento getEnderecoEstacionamento() {
		return enderecoEstacionamento;
	}

	public void setEnderecoEstacionamento(EnderecoEstacionamento enderecoEstacionamento) {
		this.enderecoEstacionamento = enderecoEstacionamento;
	}
	
}
