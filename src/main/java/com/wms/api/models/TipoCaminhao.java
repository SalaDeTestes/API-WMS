package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbTipoCaminhao")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoCaminhao {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_TipoCaminhao")
	private Long id;
	
	@Column(name = "Ds_TipoCaminhao")
	private String descricao;
	
	
	public TipoCaminhao() {
		
	}
	
	public TipoCaminhao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
