package com.manager.systems.api.domain.exception;

public class ToKenExpiradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ToKenExpiradoException(String mensagem) {
		super(mensagem);
	}
	
	public ToKenExpiradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
