package com.manager.systems.api.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Token {

	public Token() {
		super();
	}

	public Token(Long id, String token, String login, LocalDateTime expiracao, Boolean administrador) {
		super();
		this.id = id;
		this.token = token;
		this.login = login;
		this.expiracao = expiracao;
		this.administrador = administrador;
	}

	public Token(String login, Boolean administrador) {
		super();
		this.login = login;
		this.administrador = administrador;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private  String token;

	private String login;

	private LocalDateTime expiracao = LocalDateTime.now().plusMinutes(5);

	private Boolean administrador;

	@PrePersist
	public void gerarToken() {
		setToken(UUID.randomUUID().toString());
	}

	public Token(String token, String login, LocalDateTime expiracao, Boolean administrador) {
		super();
		this.token = token;
		this.login = login;
		this.expiracao = expiracao;
		this.administrador = administrador;
	}

}
