package com.wms.api.form;

import com.wms.api.models.PlacaTransportadora;
import com.wms.api.repository.PlacaTransportadoraRepository;
import com.wms.api.repository.TransportadoraRepository;

public class PlacaTransportadoraForm {

	private Integer idTransportadora;
	private Long idUf;
	private String descricao;

	public Integer getIdTransportadora() {
		return idTransportadora;
	}

	public void setIdTransportadora(Integer idTransportadora) {
		this.idTransportadora = idTransportadora;
	}

	public Long getIdUf() {
		return idUf;
	}

	public void setIdUf(Long idUf) {
		this.idUf = idUf;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PlacaTransportadora formulario(TransportadoraRepository transportadoraRepository) {

		PlacaTransportadora placa = new PlacaTransportadora();

		placa.setIdTransportadora(transportadoraRepository.getReferenceById(idTransportadora));
		placa.setIdUf(idUf);
		placa.setDescricao(descricao);

		return placa;
	}

	public PlacaTransportadora atualizar(Long id, TransportadoraRepository transportadoraRepository,
			PlacaTransportadoraRepository placaRepository) {

		PlacaTransportadora placa = placaRepository.getReferenceById(id);
		
		placa.setIdTransportadora(transportadoraRepository.getReferenceById(idTransportadora));
		placa.setIdUf(idUf);
		placa.setDescricao(descricao);

		return placa;
	}

}
