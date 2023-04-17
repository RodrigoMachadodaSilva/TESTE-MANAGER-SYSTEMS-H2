package com.manager.systems.api.domain.exception;

public class LoginInvalidoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public LoginInvalidoException(String mensagem) {
		super(mensagem);
	}

	public LoginInvalidoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	


}
