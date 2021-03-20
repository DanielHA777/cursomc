package com.daniel.cursomc.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.cursomc.domain.Pedido;
import com.daniel.cursomc.services.PedidoService;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@RestController
@RequestMapping(value = "pedidos")
public class PedidoResource {
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // obtendo dados
	public ResponseEntity<Pedido>find(@PathVariable Integer id) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
