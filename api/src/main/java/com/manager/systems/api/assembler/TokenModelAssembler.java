package com.manager.systems.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manager.systems.api.domain.model.Token;
import com.manager.systems.api.model.TokenModel;

@Component
public class TokenModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;

	public TokenModel toModel(Token token) {
		return modelMapper.map(token, TokenModel.class);

}

}