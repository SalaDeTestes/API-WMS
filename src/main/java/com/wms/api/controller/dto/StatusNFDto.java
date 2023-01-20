package com.wms.api.controller.dto;

import com.wms.api.models.StatusNF;

public class StatusNFDto {

	private Long id;
	private String descricaoStatus;

	public StatusNFDto(StatusNF status) {
		this.id = status.getId();
		this.descricaoStatus = status.getDescricaoStatus();
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricaoStatus;
	}

}
