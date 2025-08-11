package com.techchallenge.fiap.application.service;

import org.springframework.stereotype.Service;

import com.techchallenge.fiap.domain.model.Perfil;
import com.techchallenge.fiap.domain.repository.PerfilRepository;
import com.techchallenge.fiap.exception.RecursoNaoEncontradoException;

@Service
public class PerfilService {

	private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public Perfil buscarPorId(Long id) {
        return perfilRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Não foi possível encontrar o perfil selecionado"));
    }
	
}