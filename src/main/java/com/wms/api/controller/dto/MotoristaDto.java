package com.wms.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public static List<MotoristaDto> converter(List<Motorista> motorista){
		return motorista.stream().map(MotoristaDto::new).collect(Collectors.toList());
	}
	
}
