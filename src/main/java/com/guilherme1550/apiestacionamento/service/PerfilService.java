package com.guilherme1550.apiestacionamento.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme1550.apiestacionamento.model.Perfil;
import com.guilherme1550.apiestacionamento.repository.EstacionamentoRepository;
import com.guilherme1550.apiestacionamento.repository.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	PerfilRepository perfilRepository;
	
	@Autowired
	EstacionamentoRepository estacionamentoRepository;
	
	public List<Perfil> selecionarPerfis(List<String> id) {
		List<Perfil> perfis = new ArrayList<>();
		id.forEach(idPerfil -> {	
			Optional<Perfil> perfil = perfilRepository.findById(idPerfil);
			if (perfil.isPresent())
				perfis.add(perfil.get());
		});
		return perfis;
	}
}
