package com.wms.api.controller.dto;

import com.wms.api.models.TipoCaminhao;

public class TipoCaminhaoDto {

	private Long id;
	private String descricao;

	public TipoCaminhaoDto(TipoCaminhao caminhao) {
		this.id = caminhao.getId();
		this.descricao = caminhao.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}
