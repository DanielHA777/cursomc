package com.daniel.cursomc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daniel.cursomc.domain.Categoria;
import com.daniel.cursomc.repository.CategoriaRepository;

@Service
public class CategoriaService {
private CategoriaRepository repo; // dependencia do obj tipo categoria
	
	public Categoria buscar(Long id) {
		Categoria obj = repo.findAllById(id);
		return obj;
	}
}
