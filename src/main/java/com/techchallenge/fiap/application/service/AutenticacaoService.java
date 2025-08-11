package com.techchallenge.fiap.application.service;

import org.springframework.stereotype.Service;

import com.techchallenge.fiap.domain.model.Usuario;
import com.techchallenge.fiap.domain.repository.UsuarioRepository;
import com.techchallenge.fiap.dto.LoginRequestDTO;
import com.techchallenge.fiap.dto.UsuarioDTO;
import com.techchallenge.fiap.exception.CredenciaisInvalidasException;
import com.techchallenge.fiap.mapper.UsuarioMapper;

@Service
public class AutenticacaoService {

    private final UsuarioRepository usuarioRepository;

    public AutenticacaoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO autenticar(LoginRequestDTO loginDTO) {
        Usuario usuario = usuarioRepository.findByLogin(loginDTO.getLogin())
            .orElseThrow(() -> new CredenciaisInvalidasException("Credenciais inválidas"));

        if (!usuario.getSenha().equals(loginDTO.getSenha())) {
            throw new CredenciaisInvalidasException("Credenciais inválidas");
        }

        return UsuarioMapper.toDTO(usuario);
    }

}