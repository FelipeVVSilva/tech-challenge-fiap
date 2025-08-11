package com.techchallenge.fiap.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techchallenge.fiap.domain.model.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{

}