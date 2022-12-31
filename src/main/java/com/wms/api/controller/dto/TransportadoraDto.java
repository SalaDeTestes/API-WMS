package com.wms.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.wms.api.models.Transportadora;

public class TransportadoraDto {

	private Integer id;
	private String razaoSocial;
	private String cnpj;
	private String cpf;
	private String cep;
	private String cidade;
	private String telefone;
	private String email;
	private String responsavel;
	
	public TransportadoraDto(Transportadora transportadora) {
		
		this.id = transportadora.getId();
		this.razaoSocial = transportadora.getRazaoSocial();
		this.cnpj = transportadora.getCnpj();
		this.cpf = transportadora.getCpf();
		this.cep = transportadora.getCep();
		this.cidade = transportadora.getCidade();
		this.telefone = transportadora.getTelefone();
		this.email = transportadora.getEmail();
		this.responsavel = transportadora.getResponsavel();
	}

	public Integer getId() {
		return id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getResponsavel() {
		return responsavel;
	}
	
	public static List<TransportadoraDto> converter(List<Transportadora> transportadora){
		
		return transportadora.stream().map(TransportadoraDto::new).collect(Collectors.toList());
	}
	
}
