package com.manager.systems.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.systems.api.domain.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

	List<Pais> findByNomeContainingIgnoreCase(String nome);

	Pais findByNome(String nome);

}
