package com.wms.api.controller.dto;

import com.wms.api.models.Doca;

public class DocaDto {

	private Long idGalpao;
	private String descricao;
	private Boolean ocupada;
	private String numeroCarga;
	private Boolean recebimento;

	public DocaDto(Doca doca) {
		this.idGalpao = doca.getId();
		this.descricao = doca.getDescricao();
		this.ocupada = doca.getOcupada();
		this.numeroCarga = doca.getNumeroCarga();
		this.recebimento = doca.getRecebimento();
	}

	public Long getIdGalpao() {
		return idGalpao;
	}

	public String getDescricao() {
		return descricao;
	}

	public Boolean getOcupada() {
		return ocupada;
	}

	public String getNumeroCarga() {
		return numeroCarga;
	}

	public Boolean getRecebimento() {
		return recebimento;
	}

}
