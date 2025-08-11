package com.techchallenge.fiap.adapter.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techchallenge.fiap.application.service.AutenticacaoService;
import com.techchallenge.fiap.dto.LoginRequestDTO;
import com.techchallenge.fiap.dto.UsuarioDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AutenticacaoService autenticacaoService;

    public AuthController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@Valid @RequestBody LoginRequestDTO loginRequest) {
        UsuarioDTO usuario = autenticacaoService.autenticar(loginRequest);
        return ResponseEntity.ok(usuario);
    }
}