package com.wms.api.controller.dto;

import java.time.LocalDateTime;

import com.wms.api.models.Doca;
import com.wms.api.models.NotaFiscalCarga;

public class NotaFiscalCargaDto {

	private Long id;
	private LocalDateTime dataFechamento;
	private Doca idDoca;

	public NotaFiscalCargaDto(NotaFiscalCarga nfcarga) {
		this.id = nfcarga.getId();
		this.dataFechamento = nfcarga.getDataFechamento();
		this.idDoca = nfcarga.getIdDoca();

	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public Doca getIdDoca() {
		return idDoca;
	}

}
