package com.fagon.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fagon.web.entities.Contato;
import com.fagon.web.repositories.ContatoRepository;
import com.fagon.web.services.exceptions.DataIntegrityException;
import com.fagon.web.services.exceptions.ObjectNotFoundException;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;
	
	public List<Contato> findAll(){
		return repository.findAll();
	}
	
	public Contato findById(Integer id) {
		Optional<Contato> objeto = repository.findById(id);
		return objeto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo"+ ContatoService.class.getName()));
	}
	
	public Contato findByNome(String nome) {
		Optional<Contato> objeto = repository.findByNome(nome);
		return objeto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + nome + ", Tipo"+ ContatoService.class.getName()));
	}
	
	public Contato insert(Contato objeto) {
		objeto.setId(null);
		return repository.save(objeto);
	}
	
	public void updateData(Contato novoObjeto, Contato objeto) {
		novoObjeto.setNome(objeto.getNome());
		novoObjeto.setEmail(objeto.getEmail());
		novoObjeto.setNumero(objeto.getNumero());
		novoObjeto.setComplemento(objeto.getComplemento());
	}
	
	public Contato update(Contato objeto) {
		Contato novoObjeto = findById(objeto.getId());
		updateData(novoObjeto, objeto);
		return repository.save(novoObjeto);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
}

