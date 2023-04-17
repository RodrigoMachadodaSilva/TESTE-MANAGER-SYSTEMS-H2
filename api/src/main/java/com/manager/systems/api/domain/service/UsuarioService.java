package com.manager.systems.api.domain.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.systems.api.domain.exception.LoginInvalidoException;
import com.manager.systems.api.domain.model.Token;
import com.manager.systems.api.domain.model.Usuario;
import com.manager.systems.api.domain.model.UsuarioAutenticado;
import com.manager.systems.api.domain.repository.TokenRepository;
import com.manager.systems.api.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TokenRepository tokenRepository;

	public Usuario buscarUsuario(String nome, String senha) {
		return usuarioRepository.findByLoginAndSenha(nome, senha);

	}

	public UsuarioAutenticado autenticarUsuario(String login, String senha) {
		Usuario usuarioExistente = usuarioRepository.findByLoginAndSenha(login, senha);
		if (usuarioExistente != null) {
			Token token = new Token(usuarioExistente.getLogin(), usuarioExistente.getAdministrador());
			tokenRepository.save(token);

			UsuarioAutenticado autenticado = new UsuarioAutenticado(usuarioExistente.getLogin(),
					usuarioExistente.getNome(), token, usuarioExistente.getAdministrador(), true);

			return autenticado;

		} else
			throw new LoginInvalidoException(String.format("Dados de acesso inválidos"));

	}

	@org.springframework.transaction.annotation.Transactional
	public Boolean renovarToken(String token) {
		Optional<Token> tokenSalvo = tokenRepository.findByToken(token);
		if (tokenSalvo.isPresent()) {
			Token novoToken = new Token(tokenSalvo.get().getId(), tokenSalvo.get().getToken(),
					tokenSalvo.get().getLogin(), LocalDateTime.now(), tokenSalvo.get().getAdministrador());
			tokenRepository.save(novoToken);
			tokenRepository.flush();
			return true;

		}
		return false;

	}

}