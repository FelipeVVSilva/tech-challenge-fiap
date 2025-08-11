package com.techchallenge.fiap.mapper;

import com.techchallenge.fiap.domain.model.Endereco;
import com.techchallenge.fiap.dto.EnderecoDTO;

public class EnderecoMapper {

	public static Endereco toEntity(EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setIdEndereco(dto.getIdEndereco());
        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero());
        endereco.setBairro(dto.getBairro());
        endereco.setCidade(dto.getCidade());
        endereco.setEstado(dto.getEstado());
        endereco.setCep(dto.getCep());
        return endereco;
    }

    public static EnderecoDTO toDTO(Endereco endereco) {
        EnderecoDTO dto = new EnderecoDTO();
        dto.setIdEndereco(endereco.getIdEndereco());
        dto.setRua(endereco.getRua());
        dto.setNumero(endereco.getNumero());
        dto.setBairro(endereco.getBairro());
        dto.setCidade(endereco.getCidade());
        dto.setEstado(endereco.getEstado());
        dto.setCep(endereco.getCep());
        return dto;
    }
    
}