package com.wms.api.controller.dto;

import com.wms.api.models.Etiqueta;

public class EtiquetaDto {

	private Long id;
	private String descricacaoEtiqueta;
	private Long tipoEtiqueta;

	public EtiquetaDto(Etiqueta etiqueta) {
		this.id = etiqueta.getId();
		this.descricacaoEtiqueta = etiqueta.getDescricaoEtiqueta();
		this.tipoEtiqueta = etiqueta.getTipoEtiqueta();
	}

	public Long getId() {
		return id;
	}

	public String getDescricacaoEtiqueta() {
		return descricacaoEtiqueta;
	}

	public Long getTipoEtiqueta() {
		return tipoEtiqueta;
	}

}
