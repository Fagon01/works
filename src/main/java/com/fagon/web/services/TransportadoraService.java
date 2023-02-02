package com.fagon.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fagon.web.entities.Transportadora;
import com.fagon.web.repositories.TransportadoraRepository;
import com.fagon.web.services.exceptions.DatabaseException;
import com.fagon.web.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TransportadoraService {

	@Autowired
	private TransportadoraRepository repository;

	public List<Transportadora> findAll() {
		return repository.findAll();
	}

	public Transportadora findById(Long id) {
		Optional<Transportadora> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Transportadora findByRazaoSocialOuNome(String razaoSocialOuNome) {
		Optional<Transportadora> obj = repository.findByRazaoSocialOuNome(razaoSocialOuNome);
		return obj.orElseThrow(() -> new ResourceNotFoundException(razaoSocialOuNome));
	}
	
	public Transportadora findByCpfOuCnpj(String cpfOuCnpj) {
		Optional<Transportadora> obj = repository.findByCpfOuCnpj(cpfOuCnpj);
		return obj.orElseThrow(() -> new ResourceNotFoundException(cpfOuCnpj));
	}
	
	public Transportadora findByInscEstadual(String inscEstadual) {
		Optional<Transportadora> obj = repository.findByInscEstadual(inscEstadual);
		return obj.orElseThrow(() -> new ResourceNotFoundException(inscEstadual));
	}
	
	public Transportadora insert(Transportadora obj) {
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
	
	public Transportadora update(Long id, Transportadora obj) {
		try {
			Transportadora entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Transportadora entity, Transportadora obj) {
		entity.setRazaoSocialOuNome(obj.getRazaoSocialOuNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}
}