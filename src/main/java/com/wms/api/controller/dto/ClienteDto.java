package com.wms.api.controller.dto;

import java.time.LocalDateTime;

import com.wms.api.models.Cliente;

public class ClienteDto {

	private Long id;
	private String descricaoRazaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	private String descricaoEndereco;
	private String numeroEndereco;
	private String cep;
	private String telefone;
	private String email;
	private String responsavel;
	private String cargoResponsavel;
	private String nomeFantasia;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizacao;
	private Boolean situacao;

	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.descricaoRazaoSocial = cliente.getDescricaoRazaoSocial();
		this.cnpj = cliente.getCnpj();
		this.inscricaoEstadual = cliente.getInscricaoEstadual();
		this.descricaoEndereco = cliente.getDescricaoEndereco();
		this.numeroEndereco = cliente.getNumeroEndereco();
		this.cep = cliente.getCep();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
		this.responsavel = cliente.getResponsavel();
		this.cargoResponsavel = cliente.getCargoResponsavel();
		this.nomeFantasia = cliente.getNomeFantasia();
		this.dataCadastro = cliente.getDataCadastro();
		this.dataAtualizacao = cliente.getDataAtualizacao();
		this.situacao = cliente.getSituacao();
	}

	public Long getId() {
		return id;
	}

	public String getDescricaoRazaoSocial() {
		return descricaoRazaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public String getDescricaoEndereco() {
		return descricaoEndereco;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public String getCep() {
		return cep;
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

	public String getCargoResponsavel() {
		return cargoResponsavel;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public Boolean getSituacao() {
		return situacao;
	}

}
