package com.fagon.web.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fagon.web.entities.Contato;
import com.fagon.web.services.ContatoService;

@RestController
@RequestMapping(value="/contatos")
public class ContatoResource {
	
	@Autowired
	private ContatoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Contato> find(@PathVariable Integer id){
		Contato objeto = service.findById(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	@GetMapping(value = "/{nome}")
	public ResponseEntity<Contato> buscar(@PathVariable String nome){
		Contato objeto = service.findByNome(nome);
		return ResponseEntity.ok().body(objeto);
	}
	
	@GetMapping
	public ResponseEntity<List<Contato>> findAll(){
		List<Contato> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping
	public ResponseEntity<Contato> insert(@RequestBody Contato obj){
		obj =service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Contato> update(@PathVariable Integer id, @RequestBody Contato obj){
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}

}
