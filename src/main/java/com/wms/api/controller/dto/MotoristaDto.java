package com.wms.api.controller.dto;

import com.wms.api.models.Motorista;
import com.wms.api.models.Transportadora;

public class MotoristaDto {

	private Long id;
	private Transportadora idTransportadora;
	private String celular;
	private String nome;
	private String cpf;

	public MotoristaDto(Motorista motorista) {
		this.id = motorista.getId();
		this.idTransportadora = motorista.getIdTransportadora();
		this.celular = motorista.getCelular();
		this.nome = motorista.getNome();
		this.cpf = motorista.getCpf();

	}

	public Long getId() {
		return id;
	}

	public Transportadora getIdTransportadora() {
		return idTransportadora;
	}

	public String getCelular() {
		return celular;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

}
