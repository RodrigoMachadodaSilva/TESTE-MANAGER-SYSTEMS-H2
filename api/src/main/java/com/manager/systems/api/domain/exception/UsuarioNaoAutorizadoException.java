package com.manager.systems.api.domain.exception;

public class UsuarioNaoAutorizadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioNaoAutorizadoException(String mensagem) {
		super(mensagem);
	}

	public UsuarioNaoAutorizadoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
