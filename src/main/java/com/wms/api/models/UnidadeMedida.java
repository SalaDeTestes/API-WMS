package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbUnidade")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UnidadeMedida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Unidade")
	private Integer id;
	
	@Column(name = "Sg_Unidade")
	private String simbolo;
	
	@Column(name = "Ds_Unidade")
	private String descricao;
	
	public UnidadeMedida() {
		
	}
	
	public UnidadeMedida(String simbolo, String descricao) {
		this.simbolo = simbolo;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
