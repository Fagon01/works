package com.fagon.web.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fagon.web.entities.Emitente;

public interface EmitenteRepository extends JpaRepository<Emitente, Long>{
	
	Optional<Emitente> findByRazaoSocial(String razaoSocial);
	
	Optional<Emitente> findByCpfOuCnpj(String cpfOuCnpj);

}