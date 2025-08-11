package com.techchallenge.fiap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViaCepResponse {

	private String cep;
    @JsonProperty("logradouro")
    private String rua;
    private String bairro;
    @JsonProperty("localidade")
    private String cidade;
    private String estado;
   
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}