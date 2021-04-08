package com.daniel.cursomc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.cursomc.domain.Cidade;

@Repository   // tipo especial de stream capaz de acessar os dados com base no tipo q vc passar
public interface CidadeRepository2 extends JpaRepository<Cidade, Integer>{
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Cidade obj WHERE obj.estado.id = :estadoId ORDER BY obj.nome")
	public List<Cidade> findCidades(@Param("estadoId") Integer estado_id);

}
