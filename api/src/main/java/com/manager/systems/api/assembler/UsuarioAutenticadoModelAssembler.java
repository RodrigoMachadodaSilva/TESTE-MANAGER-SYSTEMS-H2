package com.manager.systems.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manager.systems.api.domain.model.UsuarioAutenticado;
import com.manager.systems.api.model.UsuarioAutenticadoModel;

@Component
public class UsuarioAutenticadoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;

	public UsuarioAutenticadoModel toModel(UsuarioAutenticado usuarioAutenticado) {
		return modelMapper.map(usuarioAutenticado, UsuarioAutenticadoModel.class);
	}




}


