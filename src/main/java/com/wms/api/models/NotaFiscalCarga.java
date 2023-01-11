package com.wms.api.models;

import java.time.LocalDateTime;

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
@Table(name = "tbControleEntradaCarga")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class NotaFiscalCarga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Nr_CargaEntrada")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_Id_Doca")
	private Doca idDoca;

	@Column(name = "dt_Fechamento")
	private LocalDateTime dataFechamento = LocalDateTime.now();
	
	@Column(name = "fg_Fechado")
	private Boolean fechado = false;

	public NotaFiscalCarga() {

	}

	public NotaFiscalCarga(Doca idDoca, LocalDateTime dataFechamento) {
		this.idDoca = idDoca;
		this.dataFechamento = dataFechamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Doca getIdDoca() {
		return idDoca;
	}

	public void setIdDoca(Doca idDoca) {
		this.idDoca = idDoca;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

}
