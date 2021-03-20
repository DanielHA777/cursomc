package com.daniel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.daniel.cursomc.domain.Categoria;
import com.daniel.cursomc.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo; // dependencia do obj tipo categoria

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjNotFoundException("Objeto não encontrado" + id + ", Tipo" + Categoria.class.getName());
		}
		return obj.orElse(null);
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null); // id valendo nulo salva
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj); // id não nulo atualiza
	}
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			
		}
	}
}
