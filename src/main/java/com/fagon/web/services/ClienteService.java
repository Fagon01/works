package com.fagon.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fagon.web.entities.Cidade;
import com.fagon.web.entities.Cliente;
import com.fagon.web.entities.Endereco;
import com.fagon.web.entities.dto.ClienteDTO;
import com.fagon.web.entities.dto.ClienteNewDTO;
import com.fagon.web.repositories.ClienteRepository;
import com.fagon.web.repositories.EnderecoRepository;
import com.fagon.web.services.exceptions.DataIntegrityException;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente find(Integer id) {
		Optional<Cliente> objeto = repository.findById(id);
		return objeto.orElse(null);
	}
	
	public Cliente findByNome(String nome) {
		Optional<Cliente> objeto = repository.findByRazaoSocialOuNome(nome);
		return objeto.orElse(null);
	}
	
	
	@Transactional
	public Cliente insert(Cliente objeto) {
		objeto.setId(null);
		objeto = repository.save(objeto);
		enderecoRepository.saveAll(objeto.getEnderecos());
		return repository.save(objeto);
	}
	
	public void updateData(Cliente novoObjeto, Cliente objeto) {
		novoObjeto.setRazaoSocialOuNome(objeto.getRazaoSocialOuNome());
		novoObjeto.setEmail(objeto.getEmail());
	}
	
	public Cliente update(Cliente objeto) {
		Cliente novoObjeto = find(objeto.getId());
		updateData(novoObjeto, objeto);
		return repository.save(novoObjeto);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		}catch(DataIntegrityException e) {
			throw new DataIntegrityException("Não é possível excluir uma empresa");
		}
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(null, objDto.getRazaoSocialOuNome(), objDto.getIndicadorDePresenca(), objDto.getInscMunicipal()
				, objDto.getInscEstadual(), objDto.getSuframa(), objDto.getEmail(), null,null, null, null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getRazaoSocialOuNome(), objDto.getIndicadorDePresenca(), objDto.getInscMunicipal()
				, objDto.getInscEstadual(), objDto.getSuframa(), objDto.getEmail(), objDto.getCpfOuCnpj(), objDto.getTipo(), null
				, objDto.getIndInscEstadual(), objDto.getConsumidorFinal());
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if(objDto.getTelefone2() != null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if(objDto.getTelefone3() != null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}
	
}
