package com.wms.api.controller.dto;

import com.wms.api.models.TipoNotaEntrada;

public class TipoNotaEntradaDto {

	private Long id;
	private String descricao;

	public TipoNotaEntradaDto(TipoNotaEntrada tipo) {

		this.id = tipo.getId();
		this.descricao = tipo.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}
