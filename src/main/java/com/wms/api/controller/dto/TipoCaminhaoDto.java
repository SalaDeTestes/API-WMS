package com.wms.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public static List<TipoCaminhaoDto> converter(List<TipoCaminhao> caminhao){
		return caminhao.stream().map(TipoCaminhaoDto::new).collect(Collectors.toList());
	}
}
