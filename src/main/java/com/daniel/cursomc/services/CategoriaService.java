package com.daniel.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.daniel.cursomc.domain.Categoria;
import com.daniel.cursomc.domain.Categoria;
import com.daniel.cursomc.domain.Categoria;
import com.daniel.cursomc.dto.CategoriaDTO;
import com.daniel.cursomc.repository.CategoriaRepository;
import com.daniel.cursomc.resources.exception.DataIntegrityException;

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
		Categoria newObj = find(obj.getId());
	updateData(newObj, obj);
		return repo.save(obj); // id não nulo atualiza
	}
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir", e);
		}
	}
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	public Page<Categoria> findPage(Integer page, Integer LinesPorPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, LinesPorPage, Direction.valueOf(direction), 
				orderBy);

		return repo.findAll(pageRequest);
		
	}
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	
	}
}
