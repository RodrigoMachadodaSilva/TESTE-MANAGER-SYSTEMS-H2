package com.manager.systems.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manager.systems.api.domain.model.Pais;
import com.manager.systems.api.model.PaisModel;

@Component
public class PaisModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;

	public PaisModel toModel(Pais pais) {
		return modelMapper.map(pais, PaisModel.class);
	}

	public List<PaisModel> toCollectionModel(List<Pais> paises) {
		return paises.stream().map(pais -> toModel(pais)).collect(Collectors.toList());
	}



}
