package com.techchallenge.fiap.adapter.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techchallenge.fiap.application.service.UsuarioService;
import com.techchallenge.fiap.dto.AlterarUsuarioDTO;
import com.techchallenge.fiap.dto.InserirUsuarioDTO;
import com.techchallenge.fiap.dto.TrocaSenhaDTO;
import com.techchallenge.fiap.dto.UsuarioDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(
            @Valid @RequestBody InserirUsuarioDTO inserirUsuarioDTO
    ) {
        UsuarioDTO criado = usuarioService.cadastrarUsuario(inserirUsuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UsuarioDTO> buscarPorEmail(@PathVariable String email) {
        UsuarioDTO dto = usuarioService.buscarUsuarioDTOPorEmail(email);
        return ResponseEntity.ok(dto);
    }
    
    @PutMapping("/{email}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(
            @PathVariable String email,
            @Valid @RequestBody AlterarUsuarioDTO alterarUsuarioDTO
    ) {
        UsuarioDTO atualizado = usuarioService.atualizarUsuario(alterarUsuarioDTO, email);
        return ResponseEntity.ok(atualizado);
    }
    
    @PutMapping("/{email}/senha")
    public ResponseEntity<Void> trocarSenha(
            @PathVariable String email,
            @Valid @RequestBody TrocaSenhaDTO dto
    ) {
        usuarioService.trocarSenhaPorEmail(email, dto);
        return ResponseEntity.noContent().build();
    }

    
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable String email) {
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.noContent().build();
    }

}