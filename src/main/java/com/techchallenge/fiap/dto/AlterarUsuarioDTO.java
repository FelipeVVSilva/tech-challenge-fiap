package com.techchallenge.fiap.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
}
