package com.fagon.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fagon.web.entities.Vendedor;
import com.fagon.web.repositories.VendedorRepository;
import com.fagon.web.services.exceptions.DatabaseException;
import com.fagon.web.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository repository;

	public List<Vendedor> findAll() {
		return repository.findAll();
	}

	public Vendedor findById(Long id) {
		Optional<Vendedor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Vendedor insert(Vendedor obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Vendedor update(Long id, Vendedor obj) {
		try {
			Vendedor entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Vendedor entity, Vendedor obj) {
		entity.setRazaoSocialOuNome(obj.getRazaoSocialOuNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}
}