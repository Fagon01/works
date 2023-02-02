package com.fagon.web.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.fagon.web.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Transactional(readOnly=true)
	Cliente findByEmail(String email);
	
	Optional<Cliente> findByRazaoSocialOuNome(String razaoSocialOuNome);
	
	Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);
	
	Optional<Cliente> findByInscEstadual(String inscEstadual);
	
}
