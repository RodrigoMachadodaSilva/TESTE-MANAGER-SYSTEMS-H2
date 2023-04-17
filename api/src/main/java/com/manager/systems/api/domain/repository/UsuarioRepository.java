package com.manager.systems.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.systems.api.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByLoginAndSenha(String login, String senha);

}
