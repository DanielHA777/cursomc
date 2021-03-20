package com.daniel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.cursomc.domain.Pedido;
import com.daniel.cursomc.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo; // dependencia do obj tipo categoria

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjNotFoundException("Objeto não encontrado" + id + ", Tipo" + Pedido.class.getName());
		}

		return obj.orElse(null);
	}
}
