package com.manager.systems.api.domain.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.systems.api.domain.exception.ToKenExpiradoException;
import com.manager.systems.api.domain.exception.TokenInvalidoException;
import com.manager.systems.api.domain.exception.UsuarioNaoAutorizadoException;
import com.manager.systems.api.domain.model.Token;
import com.manager.systems.api.domain.repository.TokenRepository;

@Service
public class TokenService {

	@Autowired
	private TokenRepository tokenRepository;

	public Token validarToken(String token) {
		Optional<Token> tokenValido = tokenRepository.findByToken(token);
		return tokenValido
				.orElseThrow(() -> new TokenInvalidoException("Token invalido, gerar um token de acesso válido"));

	}

	public void validartempoToken(LocalDateTime validadeToken) {
		LocalDateTime horaAtual = LocalDateTime.now();
		Double tempo = (double) Duration.between(horaAtual, validadeToken).toMinutes();
		if (tempo < 0) {
			throw new ToKenExpiradoException("Tempo de acesso expirado, favor revalidar seu token");

		}
	}

	public void validarAdministrador(Boolean administrador) {
		if (!administrador) {

			throw new UsuarioNaoAutorizadoException("Recurso disponível apenas para administradores");

		}

	}

}
