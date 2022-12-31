package com.wms.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.wms.api.models.PlacaTransportadora;
import com.wms.api.models.Transportadora;

public class PlacaTransportadoraDto {

	private Long id;
	private Transportadora idTransportadora;
	private Long idUf;
	private String descricao;

	public PlacaTransportadoraDto(PlacaTransportadora placa) {
		this.id = placa.getId();
		this.idTransportadora = placa.getIdTransportadora();
		this.idUf = placa.getIdUf();
		this.descricao = placa.getDescricao();

	}

	public Long getId() {
		return id;
	}

	public Transportadora getIdTransportadora() {
		return idTransportadora;
	}

	public Long getIdUf() {
		return idUf;
	}

	public String getDescricao() {
		return descricao;
	}

	public static List<PlacaTransportadoraDto> converter(List<PlacaTransportadora> placa) {

		return placa.stream().map(PlacaTransportadoraDto::new).collect(Collectors.toList());
	}
}
