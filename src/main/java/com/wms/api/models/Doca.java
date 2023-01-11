package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbDoca")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Doca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Doca")
	private Long id;

	@Column(name = "fk_Id_Galpao")
	private Long idGalpao;

	@Column(name = "Ds_Doca")
	private String descricao;

	@Column(name = "fg_Ocupada")
	private Boolean ocupada;

	@Column(name = "Nr_Carga")
	private String numeroCarga;

	@Column(name = "fg_Recebimento")
	private Boolean recebimento;

	public Doca() {

	}

	public Doca(Long idGalpao, String descricao, Boolean ocupada, String numeroCarga, Boolean recebimento) {
		this.idGalpao = idGalpao;
		this.descricao = descricao;
		this.ocupada = ocupada;
		this.numeroCarga = numeroCarga;
		this.recebimento = recebimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdGalpao() {
		return idGalpao;
	}

	public void setIdGalpao(Long idGalpao) {
		this.idGalpao = idGalpao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getOcupada() {
		return ocupada;
	}

	public void setOcupada(Boolean ocupada) {
		this.ocupada = ocupada;
	}

	public String getNumeroCarga() {
		return numeroCarga;
	}

	public void setNumeroCarga(String numeroCarga) {
		this.numeroCarga = numeroCarga;
	}

	public Boolean getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(Boolean recebimento) {
		this.recebimento = recebimento;
	}

}
