
package com.manager.systems.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisInput {

	@NotBlank
	private String nome;

	@NotBlank
	private String sigla;

	@NotBlank
	private String gentilico;

}
