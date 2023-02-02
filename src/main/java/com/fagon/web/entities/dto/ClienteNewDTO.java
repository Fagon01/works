package com.fagon.web.entities.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fagon.web.entities.enums.TipoCliente;
import com.fagon.web.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
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

	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;

	@NotEmpty(message="Preenchimento obrigatório")
	private String cpfOuCnpj;

	private Integer tipo;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;

	@NotEmpty(message="Preenchimento obrigatório")
	private String numero;

	private String complemento;

	private String bairro;

	@NotEmpty(message="Preenchimento obrigatório")
	private String cep;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String telefone1;

	private String telefone2;
	
	private String telefone3;

	private Integer cidadeId;
	
	public ClienteNewDTO() {
	}

	public String getRazaoSocialOuNome() {
		return razaoSocialOuNome;
	}

	public void setRazaoSocialOuNome(String razaoSocialOuNome) {
		this.razaoSocialOuNome = razaoSocialOuNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConsumidorFinal() {
		return consumidorFinal;
	}

	public void setConsumidorFinal(String consumidorFinal) {
		this.consumidorFinal = consumidorFinal;
	}

	public String getIndInscEstadual() {
		return indInscEstadual;
	}

	public void setIndInscEstadual(String indInscEstadual) {
		this.indInscEstadual = indInscEstadual;
	}
	
}
