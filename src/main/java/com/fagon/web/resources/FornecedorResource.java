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

import com.fagon.web.entities.Fornecedor;
import com.fagon.web.services.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResource {

	@Autowired 
	private FornecedorService service;
	
	@GetMapping
	public ResponseEntity<List<Fornecedor>> findAll() {
		List<Fornecedor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {
		Fornecedor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{razaosocialounome}")
	public ResponseEntity<Fornecedor> findByRazaoSocialOuNome(@PathVariable String razaoSocialOuNome) {
		Fornecedor obj = service.findByRazaoSocialOuNome(razaoSocialOuNome);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{cpfoucnpj}")
	public ResponseEntity<Fornecedor> findByCpfOuCnpj(@PathVariable String cpfOuCnpj) {
		Fornecedor obj = service.findByCpfOuCnpj(cpfOuCnpj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{inscricaoestadual}")
	public ResponseEntity<Fornecedor> findByInscEstadual(@PathVariable String inscEstadual) {
		Fornecedor obj = service.findByInscEstadual(inscEstadual);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Fornecedor> insert(@RequestBody Fornecedor obj) {
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
	public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}