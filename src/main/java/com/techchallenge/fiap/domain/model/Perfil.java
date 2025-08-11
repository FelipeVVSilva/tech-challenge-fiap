package com.techchallenge.fiap.domain.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbPerfil")
public class Perfil {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPerfil;
	
	@Column(nullable = false, unique = true)
	private String perfilAcesso;
	
	public Perfil() {
		super();
	}
	
	public Long getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getPerfilAcesso() {
		return perfilAcesso;
	}
	public void setPerfilAcesso(String perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idPerfil);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		return Objects.equals(idPerfil, other.idPerfil);
	}
}