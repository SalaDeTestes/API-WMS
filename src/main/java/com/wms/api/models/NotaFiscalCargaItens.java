package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbControleEntradaCargaItens")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class NotaFiscalCargaItens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Item")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_Id_CargaEntrada")
	private NotaFiscalCarga idNotaFiscalCarga;

	@ManyToOne
	@JoinColumn(name = "fk_Id_ControleEntrada")
	private NotaFiscal idNotaFiscal;

	public NotaFiscalCargaItens() {

	}

	public NotaFiscalCargaItens(NotaFiscal idNotaFiscal, NotaFiscalCarga idNotaFiscalCarga) {
		this.idNotaFiscal = idNotaFiscal;
		this.idNotaFiscalCarga = idNotaFiscalCarga;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NotaFiscalCarga getIdNotaFiscalCarga() {
		return idNotaFiscalCarga;
	}

	public void setIdNotaFiscalCarga(NotaFiscalCarga idNotaFiscalCarga) {
		this.idNotaFiscalCarga = idNotaFiscalCarga;
	}

	public NotaFiscal getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(NotaFiscal idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

}
