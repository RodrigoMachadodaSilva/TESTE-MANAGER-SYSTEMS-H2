package com.manager.systems.api.domain.exception;

public class PaisNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PaisNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}
