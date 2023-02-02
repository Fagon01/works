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

import com.fagon.web.entities.Emitente;
import com.fagon.web.services.EmitenteService;

@RestController
@RequestMapping(value = "/emitentes")
public class EmitenteResource {

	@Autowired 
	private EmitenteService service;
	
	@GetMapping
	public ResponseEntity<List<Emitente>> findAll() {
		List<Emitente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Emitente> findById(@PathVariable Long id) {
		Emitente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{razaosocial}")
	public ResponseEntity<Emitente> findByRazaSocialOuNome(@PathVariable String razaoSocialOuNome) {
		Emitente obj = service.findByRazaoSocialOuNome(razaoSocialOuNome);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{cpfoucnpj}")
	public ResponseEntity<Emitente> findByCpfOuCnpj(@PathVariable String cpfOuCnpj) {
		Emitente obj = service.findByCpfOuCnpj(cpfOuCnpj);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Emitente> insert(@RequestBody Emitente obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Emitente> update(@PathVariable Long id, @RequestBody Emitente obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}