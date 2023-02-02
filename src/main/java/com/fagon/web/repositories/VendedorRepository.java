package com.fagon.web.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fagon.web.entities.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{
	
	Optional<Vendedor> findByRazaoSocialOuNome(String razaoSocialOuNome);
	
	Optional<Vendedor> findByCpfOuCnpj(String cpfOuCnpj);

}