package com.daniel.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.cursomc.domain.Cidade;
import com.daniel.cursomc.repository.CidadeRepository2;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository2 repo;

	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
}   