package com.techchallenge.fiap.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EnderecoDTO {

	private Long idEndereco;

    @NotBlank(message = "A rua é obrigatória.")
    @Size(min = 3, max = 80, message = "A rua deve ter entre 3 e 80 caracteres.")
    private String rua;

    @NotBlank(message = "O número é obrigatório.")
    @Size(min = 1, max = 10, message = "O número deve ter até 10 caracteres.")
    private String numero;

    @NotBlank(message = "O bairro é obrigatório.")
    @Size(min = 3, max = 50, message = "O bairro deve ter entre 3 e 50 caracteres.")
    private String bairro;

    @NotBlank(message = "A cidade é obrigatória.")
    @Size(min = 2, max = 60, message = "A cidade deve ter entre 2 e 60 caracteres.")
    private String cidade;

    @NotBlank(message = "O estado é obrigatório.")
    @Size(min = 2, max = 2, message = "O estado deve ter exatamente 2 caracteres (ex: SP, RJ).")
    private String estado;
    @NotBlank(message = "O CEP é obrigatório.")
    
    @NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve ter o formato 00000-000.")
    private String cep;
    
	public Long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
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
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
}