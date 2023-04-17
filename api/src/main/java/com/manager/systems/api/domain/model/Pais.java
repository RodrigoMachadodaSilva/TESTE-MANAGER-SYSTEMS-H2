package com.manager.systems.api.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "nome", "sigla", "gentilico" }) })
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String nome;

	@Column(unique = true)
	private String sigla;

	@Column(unique = true)
	private String gentilico;

}
