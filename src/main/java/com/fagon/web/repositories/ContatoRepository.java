package com.fagon.web.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fagon.web.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer>{
	
	Optional<Contato> findByNome(String nome);

}
