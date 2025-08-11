package com.techchallenge.fiap.dto;

import java.time.LocalDateTime;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {
	
	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 3, max = 60, message = "O nome deve ter entre 3 e 60 caracteres.")
	private String nome;

	@NotBlank(message = "O login é obrigatório.")
	@Size(min = 5, max = 30, message = "O nome deve ter entre 5 e 30 caracteres.")
	private String login;
	
	@NotBlank(message = "O email é obrigatório.")
	@Size(min = 5, max = 100, message = "O email deve ter entre 5 e 100 caracteres.")
	@Email(message = "Email inválido.")
	private String email;

	@NotBlank(message = "A senha é obrigatória.")
	@Size(min = 8, max = 64, message = "A senha deve ter entre 8 e 64 caracteres.")
	private String senha;

	private LocalDateTime dataUltimaAlteracao;

	@NotNull(message = "O endereço é obrigatório.")
	@Valid
	private EnderecoDTO endereco;
	
	@NotNull(message = "O perfil é obrigatório.")
	private Long idPerfil;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public LocalDateTime getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}
	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	public Long getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

}