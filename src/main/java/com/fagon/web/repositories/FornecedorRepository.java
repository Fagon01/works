package com.fagon.web.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fagon.web.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
	
	Optional<Fornecedor> findByRazaoSocialOuNome(String razaoSocialOuNome);
	
	Optional<Fornecedor> findByInscEstadual(String inscEstadual);
	
	Optional<Fornecedor> findByCpfOuCnpj(String cpfOuCnpj);

}