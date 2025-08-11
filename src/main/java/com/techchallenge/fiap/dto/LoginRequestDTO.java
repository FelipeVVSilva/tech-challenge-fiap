package com.techchallenge.fiap.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequestDTO {

	@NotBlank(message = "O email é obrigatório.")
	@Email(message = "Email inválido.")
	private String login;

	@NotBlank(message = "A senha é obrigatória.")
	@Size(min = 8, max = 64, message = "A senha deve ter entre 8 e 64 caracteres.")
	private String senha;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}