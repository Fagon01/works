package com.fagon.web.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_vendedor")
public class Vendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer tipo;
	private String cpfOuCnpj;
	private String razaoSocialOuNome;
	
	private String cep;
	private String logradouro;
	private Integer numero;
	private String bairro;
	private String complemento;
	private String municipio;
	private String ufEnd;
	
	@Column(unique=true)
	private String email;
	private String contatoEmail;	
	private String telefone;
	private String contato;
	
	public Vendedor() {	
	}

	public Vendedor(Long id, Integer tipo, String cpfOuCnpj, String razaoSocialOuNome, String cep, String logradouro,
			Integer numero, String bairro, String complemento, String municipio, String ufEnd, String email,
			String contatoEmail, String telefone, String contato) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.cpfOuCnpj = cpfOuCnpj;
		this.razaoSocialOuNome = razaoSocialOuNome;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.municipio = municipio;
		this.ufEnd = ufEnd;
		this.email = email;
		this.contatoEmail = contatoEmail;
		this.telefone = telefone;
		this.contato = contato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getRazaoSocialOuNome() {
		return razaoSocialOuNome;
	}

	public void setRazaoSocialOuNome(String razaoSocialOuNome) {
		this.razaoSocialOuNome = razaoSocialOuNome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUfEnd() {
		return ufEnd;
	}

	public void setUfEnd(String ufEnd) {
		this.ufEnd = ufEnd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContatoEmail() {
		return contatoEmail;
	}

	public void setContatoEmail(String contatoEmail) {
		this.contatoEmail = contatoEmail;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpfOuCnpj, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(cpfOuCnpj, other.cpfOuCnpj) && Objects.equals(id, other.id);
	}
	
}