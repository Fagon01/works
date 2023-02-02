package com.fagon.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fagon.web.entities.Emitente;
import com.fagon.web.repositories.EmitenteRepository;
import com.fagon.web.services.exceptions.DatabaseException;
import com.fagon.web.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmitenteService {

	@Autowired
	private EmitenteRepository repository;

	public List<Emitente> findAll() {
		return repository.findAll();
	}

	public Emitente findById(Long id) {
		Optional<Emitente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Emitente insert(Emitente obj) {
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
	
	public Emitente update(Long id, Emitente obj) {
		try {
			Emitente entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Emitente entity, Emitente obj) {
		entity.setRazaoSocial(obj.getRazaoSocial());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}
}