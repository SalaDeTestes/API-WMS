package com.wms.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.wms.api.models.StatusNF;

public class StatusNFDto {

	private Long id;
	private String descricao;
	
	
	public StatusNFDto(StatusNF status) {
		this.id = status.getId();
		this.descricao = status.getDescricaoStatus();
	}


	public Long getId() {
		return id;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static List<StatusNFDto> converter(List<StatusNF> status){
		
		return status.stream().map(StatusNFDto::new).collect(Collectors.toList());
	}
}
