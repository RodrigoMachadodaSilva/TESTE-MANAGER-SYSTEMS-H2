package com.manager.systems.api.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.systems.api.domain.model.Pais;
import com.manager.systems.api.domain.repository.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private TokenService tokenService;

	public List<Pais> listarPaises(String token) {
		tokenService.validarToken(token);
		return paisRepository.findAll();
	}

	public List<Pais> buscarPorNome(String nome) {
		return paisRepository.findByNomeContainingIgnoreCase(nome);

	}
	
	@Transactional
	public void excluirPais(Long id) {
		paisRepository.deleteById(id);

	}

	@Transactional
	public Pais salvar(Pais pais) {
		Pais paisSalvo = paisRepository.findByNome(pais.getNome());
		if (paisSalvo == null) {
			return paisRepository.save(pais);

		}
		BeanUtils.copyProperties(pais, paisSalvo, "id");
		return paisSalvo;

	}

}
