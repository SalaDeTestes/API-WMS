package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbEtiquetas")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Etiqueta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Etiqueta")
	private Long id;

	@Column(name = "Ds_Etiqueta")
	private String descricaoEtiqueta = "0";

	@Column(name = "fk_Id_TipoEtiqueta")
	private Long tipoEtiqueta = (long) 1;

	public Etiqueta() {

	}

	public Etiqueta(String descricaoEtiqueta, Long tipoEtiqueta) {
		this.descricaoEtiqueta = descricaoEtiqueta;
		this.tipoEtiqueta = tipoEtiqueta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoEtiqueta() {
		return descricaoEtiqueta;
	}

	public void setDescricaoEtiqueta(String descricaoEtiqueta) {
		this.descricaoEtiqueta = descricaoEtiqueta;
	}

	public Long getTipoEtiqueta() {
		return tipoEtiqueta;
	}

	public void setTipoEtiqueta(Long tipoEtiqueta) {
		this.tipoEtiqueta = tipoEtiqueta;
	}

}
