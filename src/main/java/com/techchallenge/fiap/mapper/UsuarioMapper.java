package com.techchallenge.fiap.mapper;

import com.techchallenge.fiap.domain.model.Endereco;
import com.techchallenge.fiap.domain.model.Perfil;
import com.techchallenge.fiap.domain.model.Usuario;
import com.techchallenge.fiap.dto.InserirUsuarioDTO;
import com.techchallenge.fiap.dto.UsuarioDTO;

public class UsuarioMapper {

	public static Usuario toEntity(UsuarioDTO dto, Perfil perfil, Endereco endereco) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setLogin(dto.getLogin());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setDataUltimaAlteracao(dto.getDataUltimaAlteracao());
        usuario.setEndereco(endereco);
        usuario.setPerfil(perfil);
        return usuario;
    }

	public static Usuario toEntity(InserirUsuarioDTO dto, Perfil perfil, Endereco endereco) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setLogin(dto.getLogin());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setDataUltimaAlteracao(dto.getDataUltimaAlteracao());
        usuario.setEndereco(endereco);
        usuario.setPerfil(perfil);
        return usuario;
    }
	
    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setLogin(usuario.getLogin());
        dto.setSenha(null);
        dto.setDataUltimaAlteracao(usuario.getDataUltimaAlteracao());
        dto.setEndereco(EnderecoMapper.toDTO(usuario.getEndereco()));
        dto.setIdPerfil(usuario.getPerfil() != null ? usuario.getPerfil().getIdPerfil() : null);
        return dto;
    }
    
}