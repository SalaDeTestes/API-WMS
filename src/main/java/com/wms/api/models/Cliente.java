package com.wms.api.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "\"tbCliente\"")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Cliente")
	private Long id;
	
	@Column(name = "Ds_RazaoSocial")
	private String descricaoRazaoSocial;
	
	@Column(name = "Nr_CNPJ")
	private String cnpj;
	
	@Column(name = "Nr_InscricaoEstadual")
	private String inscricaoEstadual;
	
	@Column(name = "Ds_Endereco")
	private String descricaoEndereco;
	
	@Column(name = "Nr_Endereco")
	private String numeroEndereco;
	
	@Column(name = "Nr_CEP")
	private String cep;
	
	@Column(name = "Ds_Telefone")
	private String telefone;
	
	@Column(name = "Ds_Email")
	private String email;
	
	@Column(name = "Ds_Responsavel1")
	private String responsavel;
	
	@Column(name = "Ds_Cargo1")
	private String cargoResponsavel;
	
	@Column(name = "Ds_NomeFantasia")
	private String nomeFantasia;
	
	@Column(name = "Dt_Cadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name = "Dt_Atualizacao")
	private LocalDateTime dataAtualizacao;
	
	@Column(name = "Fg_AtivoInativo")
	private Boolean situacao;
		   
		  
	public Cliente() {
		
	}
	
	public Cliente(String descricaoRazaoSocial, String cnpj, String inscricaoEstadual, String descricaoEndereco, String numeroEndereco, String cep, String telefone, String email, String responsavel, String cargoResponsavel, String nomeFantasia, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao, Boolean situacao) {
		this.descricaoRazaoSocial = descricaoRazaoSocial;
		this.cnpj = cnpj;
		this.inscricaoEstadual =inscricaoEstadual;
		this.descricaoEndereco = descricaoEndereco;
		this.numeroEndereco = numeroEndereco;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
		this.responsavel = responsavel;
		this.cargoResponsavel = cargoResponsavel;
		this.nomeFantasia = nomeFantasia;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoRazaoSocial() {
		return descricaoRazaoSocial;
	}

	public void setDescricaoRazaoSocial(String descricaoRazaoSocial) {
		this.descricaoRazaoSocial = descricaoRazaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getDescricaoEndereco() {
		return descricaoEndereco;
	}

	public void setDescricaoEndereco(String descricaoEndereco) {
		this.descricaoEndereco = descricaoEndereco;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getCargoResponsavel() {
		return cargoResponsavel;
	}

	public void setCargoResponsavel(String cargoResponsavel) {
		this.cargoResponsavel = cargoResponsavel;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
	
	
		      
		     
}
