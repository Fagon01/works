package com.fagon.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fagon.web.entities.Estado;
import com.fagon.web.repositories.EstadoRepository;

public class EstadoService {
	
	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> findAll() {
		return repository.findAllByOrderByNome();
	}

}
