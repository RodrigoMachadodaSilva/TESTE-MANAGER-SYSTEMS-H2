package com.manager.systems.api.controlleropenapi;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.manager.systems.api.model.PaisModel;
import com.manager.systems.api.model.input.PaisInput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pais")
public interface PaisControllerOpenApi {

	@Operation(summary = "Lista os países", responses = { @ApiResponse(responseCode = "200"),
			@ApiResponse(responseCode = "401", description = "Token do páis inválido")

	})

	List<PaisModel> listarPaises(@PathVariable(name = "Token de autenticação", required = true) String token);

	@Operation(summary = "Lista os países con busca dinâmica pelo nome", responses = {
			@ApiResponse(responseCode = "200"),
			@ApiResponse(responseCode = "401", description = "Token do páis inválido")

	})

	List<PaisModel> buscarPais(@PathVariable(name = "Token de autenticação", required = true) String token,
			@RequestParam(name = "Nome do país", required = false) String nome);

	@Operation(summary = "Deleta os países pelo Id", responses = { @ApiResponse(responseCode = "201"),
			@ApiResponse(responseCode = "401", description = "Token do páis inválido", content = {
					@Content(schema = @Schema(ref = "Problema")) })

	})
	Boolean deletarPais(@PathVariable(name = "Id do país", required = true) Long id,
			@RequestParam(name = "Token de autenticação", required = true) String token);

	@Operation(summary = "Salva um pais ou atualiza pelo Id", responses = { @ApiResponse(responseCode = "201"),
			@ApiResponse(responseCode = "401", description = "Token do páis inválido", content = {
					@Content(schema = @Schema(ref = "Problema")) }) })
	PaisModel salvar(@RequestParam String token, @RequestBody PaisInput paisInput);

}