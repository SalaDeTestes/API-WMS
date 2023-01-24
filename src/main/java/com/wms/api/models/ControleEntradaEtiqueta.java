package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbControleEntradaEtiqueta")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ControleEntradaEtiqueta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Identificador")
	private Long id;

	@Column(name = "fk_Id_Etiqueta")
	private Long idEtiqueta;

	@Column(name = "fk_Id_ControleEntrada")
	private Long IdNotaFiscal;

	public ControleEntradaEtiqueta() {

	}

	public ControleEntradaEtiqueta(Long idEtiqueta, Long idNotaFiscal) {
		this.idEtiqueta = idEtiqueta;
		this.IdNotaFiscal = idNotaFiscal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEtiqueta() {
		return idEtiqueta;
	}

	public void setIdEtiqueta(Long idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public Long getIdNotaFiscal() {
		return IdNotaFiscal;
	}

	public void setIdNotaFiscal(Long idNotaFiscal) {
		IdNotaFiscal = idNotaFiscal;
	}

}
