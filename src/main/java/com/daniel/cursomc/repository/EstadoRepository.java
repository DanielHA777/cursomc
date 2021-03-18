package com.daniel.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.cursomc.domain.Categoria;
import com.daniel.cursomc.domain.Estado;

@Repository   // tipo especial de stream capaz de acessar os dados com base no tipo q vc passar
public interface EstadoRepository extends JpaRepository<Estado, Integer>{


}
