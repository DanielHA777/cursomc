package com.daniel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.cursomc.domain.Cliente;
import com.daniel.cursomc.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo; // dependencia do obj tipo categoria

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjNotFoundException("Objeto não encontrado" + id + ", Tipo" + Cliente.class.getName());
		}

		return obj.orElse(null);
	}
}
