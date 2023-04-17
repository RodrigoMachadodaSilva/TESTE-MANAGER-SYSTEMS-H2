package com.manager.systems.api.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.manager.systems.api.utils.Criptografar;

import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "login" }) })
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String login;

	private String senha;

	private String nome;

	private Boolean administrador;

	@PrePersist
	public void criptografarSenha() {
		setSenha(Criptografar.encriptografar(senha));
	}
}
