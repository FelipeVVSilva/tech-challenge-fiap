package com.techchallenge.fiap.application.service;

import org.springframework.stereotype.Service;

import com.techchallenge.fiap.domain.model.Endereco;
import com.techchallenge.fiap.domain.repository.EnderecoRepository;
import com.techchallenge.fiap.dto.ViaCepResponse;

@Service
public class EnderecoService {

	private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;

    public EnderecoService(EnderecoRepository enderecoRepository, ViaCepService viaCepService) {
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }

    public Endereco criarEndereco(String cep, String numero) {
        ViaCepResponse viaCep = viaCepService.buscarEnderecoPorCep(cep);

        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        endereco.setNumero(numero);
        endereco.setRua(viaCep.getRua());
        endereco.setBairro(viaCep.getBairro());
        endereco.setCidade(viaCep.getCidade());
        endereco.setEstado(viaCep.getEstado());

        return enderecoRepository.save(endereco);
    }
}