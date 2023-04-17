
package com.manager.systems.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.manager.systems.api.assembler.PaisModelAssembler;
import com.manager.systems.api.controlleropenapi.PaisControllerOpenApi;
import com.manager.systems.api.disassembler.PaisInputDisassembler;
import com.manager.systems.api.domain.model.Pais;
import com.manager.systems.api.domain.model.Token;
import com.manager.systems.api.domain.service.PaisService;
import com.manager.systems.api.domain.service.TokenService;
import com.manager.systems.api.model.PaisModel;
import com.manager.systems.api.model.input.PaisInput;

@RestController
@RequestMapping("/pais")
public class PaisController implements PaisControllerOpenApi {

	@Autowired
	private PaisService paisService;

	@Autowired
	private PaisModelAssembler paisModelAssembler;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private PaisInputDisassembler paisInputDisassembler;

	@GetMapping
	public List<PaisModel> listarPaises(@RequestParam String token) {
		acessoConvidado(token);

		List<Pais> paises = paisService.listarPaises(token);

		return paisModelAssembler.toCollectionModel(paises);

	}

	@GetMapping("/pesquisar")
	public List<PaisModel> buscarPais(@RequestParam String nome, @RequestParam String token) {
		acessoConvidado(token);

		List<Pais> paises = paisService.buscarPorNome(nome);

		return paisModelAssembler.toCollectionModel(paises);
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public PaisModel salvar(@RequestBody String token, @RequestBody @Valid PaisInput paisInput) {
		acessoAdministrador(token);

		Pais pais = paisInputDisassembler.toDomainObject(paisInput);

		Pais paisSalvo = paisService.salvar(pais);

		return paisModelAssembler.toModel(paisSalvo);
	}

	@DeleteMapping("/{paisId}")
	public Boolean deletarPais(@PathVariable Long paisId, @RequestParam String token) {
		acessoAdministrador(token);
		try {

			paisService.excluirPais(paisId);
			return true;

		} catch (EmptyResultDataAccessException e) {
			return false;

		}

	}

	private void acessoAdministrador(String token) {
		Token tokenValido = tokenService.validarToken(token);
		tokenService.validartempoToken(tokenValido.getExpiracao());
		tokenService.validarAdministrador(tokenValido.getAdministrador());

	}

	private void acessoConvidado(String token) {
		Token tokenValido = tokenService.validarToken(token);
		tokenService.validartempoToken(tokenValido.getExpiracao());

	}

}
