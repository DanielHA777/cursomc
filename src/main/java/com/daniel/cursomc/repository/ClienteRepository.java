package com.daniel.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.cursomc.domain.Categoria;
import com.daniel.cursomc.domain.Cliente;

@Repository   // tipo especial de stream capaz de acessar os dados com base no tipo q vc passar
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Transactional(readOnly = true)
Cliente findByEmail(String email);
}
