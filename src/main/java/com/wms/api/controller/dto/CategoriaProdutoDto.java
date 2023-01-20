package com.wms.api.controller.dto;

import com.wms.api.models.CategoriaProduto;

public class CategoriaProdutoDto {
	private Long id;
	private String descricaoCategoria;

	public CategoriaProdutoDto(CategoriaProduto categoriaProduto) {
		this.id = categoriaProduto.getId();
		this.descricaoCategoria = categoriaProduto.getDescricaoCategoria();
	}

	public Long getId() {
		return id;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

}
