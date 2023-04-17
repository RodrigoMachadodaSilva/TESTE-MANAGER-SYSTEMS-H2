
package com.manager.systems.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manager.systems.api.assembler.UsuarioAutenticadoModelAssembler;
import com.manager.systems.api.controlleropenapi.UsuarioControllerOpenApi;
import com.manager.systems.api.domain.model.UsuarioAutenticado;
import com.manager.systems.api.domain.service.UsuarioService;
import com.manager.systems.api.model.UsuarioAutenticadoModel;

@RestController

@RequestMapping("/usuario")
public class UsuarioController implements UsuarioControllerOpenApi {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioAutenticadoModelAssembler usuarioAutenticadoModelAssembler;

	@PostMapping("/autenticar")
	public UsuarioAutenticadoModel autenticarUsuario(@RequestParam String login, @RequestParam String senha) {

		UsuarioAutenticado usuarioAutenticado = usuarioService.autenticarUsuario(login, senha);
		return usuarioAutenticadoModelAssembler.toModel(usuarioAutenticado);
	}

	@GetMapping("/renovar-ticket")
	public Boolean renovarTicket(@RequestParam String token) {
		return usuarioService.renovarToken(token);
	}

}
