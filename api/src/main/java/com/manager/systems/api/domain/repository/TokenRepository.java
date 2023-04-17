package com.manager.systems.api.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.systems.api.domain.model.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {

	Optional<Token> findByToken(String token);

}
