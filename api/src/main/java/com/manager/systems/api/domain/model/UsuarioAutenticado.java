package com.manager.systems.api.domain.model;

import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class UsuarioAutenticado {

	public UsuarioAutenticado() {
		super();
	}

	public UsuarioAutenticado(String login, String nome, Token token, Boolean administrador, Boolean autenticado) {
		super();
		this.login = login;
		this.nome = nome;
		this.token = token;
		this.administrador = administrador;
		this.autenticado = autenticado;
	}

	private String login;

	private String nome;

	@OneToOne
	private Token token;

	private Boolean administrador;

	private Boolean autenticado;

}