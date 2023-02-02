package com.fagon.web.entities.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fagon.web.entities.Cliente;
import com.fagon.web.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String razaoSocialOuNome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String indicadorDePresenca;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String inscMunicipal;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String inscEstadual;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String suframa;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String indInscEstadual;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String consumidorFinal;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	public ClienteDTO() {
	}

	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		razaoSocialOuNome = obj.getRazaoSocialOuNome();
		email = obj.getEmail();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocialOuNome() {
		return razaoSocialOuNome;
	}

	public void setRazaoSocialOuNome(String nome) {
		this.razaoSocialOuNome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndicadorDePresenca() {
		return indicadorDePresenca;
	}

	public void setIndicadorDePresenca(String indicadorDePresenca) {
		this.indicadorDePresenca = indicadorDePresenca;
	}

	public String getInscMunicipal() {
		return inscMunicipal;
	}

	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getSuframa() {
		return suframa;
	}

	public void setSuframa(String suframa) {
		this.suframa = suframa;
	}

	public String getindInscEstadual() {
		return indInscEstadual;
	}

	public void setindInscEstadual(String indInscEstadual) {
		this.indInscEstadual = indInscEstadual;
	}

	public String getConsumidorFinal() {
		return consumidorFinal;
	}

	public void setConsumidorFinal(String consumidorFinal) {
		this.consumidorFinal = consumidorFinal;
	}
	
}
