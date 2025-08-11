package com.techchallenge.fiap.application.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.techchallenge.fiap.dto.ViaCepResponse;
import com.techchallenge.fiap.exception.RecursoNaoEncontradoException;

@Service
public class ViaCepService {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://viacep.com.br/ws")
            .build();

    public ViaCepResponse buscarEnderecoPorCep(String cep) {
        try {
            return webClient.get()
                .uri("/{cep}/json", cep)
                .retrieve()
                .bodyToMono(ViaCepResponse.class)
                .blockOptional()
                .filter(resp -> resp.getCep() != null && !resp.getCep().isEmpty())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Não foi possível encontrar o CEP " + cep ));
        } catch (RecursoNaoEncontradoException e) {
			throw e;
		}
        catch (Exception e) {
            throw new RecursoNaoEncontradoException("Erro ao buscar o CEP " + cep);
        }
    }
}