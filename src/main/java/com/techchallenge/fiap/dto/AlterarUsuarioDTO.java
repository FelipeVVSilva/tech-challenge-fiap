package com.techchallenge.fiap.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AlterarUsuarioDTO {

	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 3, max = 60, message = "O nome deve ter entre 3 e 60 caracteres.")
	private String nome;

	@NotBlank(message = "O email é obrigatório.")
	@Size(min = 5, max = 100, message = "O email deve ter entre 5 e 100 caracteres.")
	@Email(message = "Email inválido.")
	private String email;
	
	@NotNull(message = "O perfil é obrigatório.")
	private Long idPerfil;
	
	@NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve ter o formato 00000-000.")
	private String cep;
	
	@NotBlank(message = "O numero é obrigatória.")
	@Size(min = 1, max = 20, message = "O número deve ter entre 1 e 20 caracteres.")
	private String numero;
	
	@Size(min = 1, max = 50, message = "O complemento deve ter entre 1 e 50 caracteres.")
	private String complemento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
