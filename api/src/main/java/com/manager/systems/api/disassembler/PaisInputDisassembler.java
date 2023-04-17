package com.manager.systems.api.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manager.systems.api.domain.model.Pais;
import com.manager.systems.api.model.input.PaisInput;
@Component
public class PaisInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Pais toDomainObject(PaisInput paisInput) {
		return modelMapper.map(paisInput, Pais.class);
	}

}
