package com.manager.systems.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioAutenticadoModel {

	private Boolean autenticado;

	private TokenModel token;

}
