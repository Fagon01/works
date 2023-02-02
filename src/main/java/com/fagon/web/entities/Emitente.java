package com.fagon.web.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_emitente")
public class Emitente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer tipoDocumento;
	private String cpfOuCnpj;
	private Integer uf;
	private String razaoSocial;
	private String nomeFantasia;
	private String inscEstadual;
	private Boolean isento;
	private String inscEstadualSubstituto;
	private String inscMunicipal;
	private String cnae;
	private String regimeTributario;

	/*
	 * ENDEREÇO
	 */

	private String cep;
	private String logradouro;
	private Integer numero;
	private String bairro;
	private String complemento;
	private String municipio;
	private String ufEnd;

	/*
	 * Contato
	 */

	private String email;
	private String telefone;

	public Emitente(Long id, Integer tipoDocumento, String cpfOuCnpj, Integer uf, String razaoSocial,
			String nomeFantasia, String inscEstadual, Boolean isento, String inscEstadualSubstituto,
			String inscMunicipal, String cnae, String regimeTributario, String cep, String logradouro, Integer numero,
			String bairro, String complemento, String municipio, String ufEnd, String email, String telefone) {
		super();
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.cpfOuCnpj = cpfOuCnpj;
		this.uf = uf;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.inscEstadual = inscEstadual;
		this.isento = isento;
		this.inscEstadualSubstituto = inscEstadualSubstituto;
		this.inscMunicipal = inscMunicipal;
		this.cnae = cnae;
		this.regimeTributario = regimeTributario;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.municipio = municipio;
		this.ufEnd = ufEnd;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getUf() {
		return uf;
	}

	public void setUf(Integer uf) {
		this.uf = uf;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public Boolean getIsento() {
		return isento;
	}

	public void setIsento(Boolean isento) {
		this.isento = isento;
	}

	public String getInscEstadualSubstituto() {
		return inscEstadualSubstituto;
	}

	public void setInscEstadualSubstituto(String inscEstadualSubstituto) {
		this.inscEstadualSubstituto = inscEstadualSubstituto;
	}

	public String getInscMunicipal() {
		return inscMunicipal;
	}

	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}

	public String getRegimeTributario() {
		return regimeTributario;
	}

	public void setRegimeTributario(String regimeTributario) {
		this.regimeTributario = regimeTributario;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		Emitente other = (Emitente) obj;
		return Objects.equals(cpfOuCnpj, other.cpfOuCnpj) && Objects.equals(id, other.id);
	}

}
