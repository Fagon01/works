package com.fagon.web.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fagon.web.entities.Transportadora;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Long>{
	
	Optional<Transportadora> findByRazaoSocialOuNome(String razaoSocialOuNome);
	
	Optional<Transportadora> findByInscEstadual(String inscEstadual);
	
	Optional<Transportadora> findByCpfOuCnpj(String cpfOuCnpj);

}
