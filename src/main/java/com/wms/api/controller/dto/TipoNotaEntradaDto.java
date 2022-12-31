package com.wms.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public static List<TipoNotaEntradaDto> converter(List<TipoNotaEntrada> tipo){
		
		return tipo.stream().map(TipoNotaEntradaDto::new).collect(Collectors.toList());
		
	}
}
