package com.fagon.web.entities.dto;

import java.io.Serializable;

import com.fagon.web.entities.Produto;

public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String descricao;
	private Double preco;
	
	ProdutoDTO(){
	}
	
	public ProdutoDTO(Produto objeto){
		id = objeto.getId();
		nome = objeto.getNome();
		descricao = objeto.getDescricao();
		preco = objeto.getPreco();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
