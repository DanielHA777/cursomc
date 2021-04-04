package com.daniel.cursomc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.cursomc.domain.Cliente;
import com.daniel.cursomc.domain.Pedido;

@Repository   // tipo especial de stream capaz de acessar os dados com base no tipo q vc passar
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	@Transactional(readOnly=true)
	Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);

}
