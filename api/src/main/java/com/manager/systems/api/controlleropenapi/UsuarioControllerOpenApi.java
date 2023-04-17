package com.manager.systems.api.controlleropenapi;

import org.springframework.web.bind.annotation.RequestParam;

import com.manager.systems.api.model.UsuarioAutenticadoModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuario")
public interface UsuarioControllerOpenApi {

	@Operation(summary = "Faz login e autentica o usuário", responses = { @ApiResponse(responseCode = "201"),
			@ApiResponse(responseCode = "401", description = "Dados de login inválidos"

			), })
	UsuarioAutenticadoModel autenticarUsuario(@RequestParam(name = "Login do Usuário", required = true) String login,
			@RequestParam(name = "Senha do Usuário", required = true) String senha);

	@Operation(summary = "Reautentica o usuário", description = "Gera um nova token", responses = {
			@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "401", description = "Token inválido"

			), })
	Boolean renovarTicket(@RequestParam(name = "Token do usuário", required = true) String token);

}