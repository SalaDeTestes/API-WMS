package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbTransportadora")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transportadora {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Transportadora")
	private Integer id;
	
	@Column(name = "Ds_RazaoSocial")
	private String razaoSocial;
	
	@Column(name = "Nr_CNPJ")
	private String cnpj;
	
	@Column(name = "Nr_CPF")
	private String cpf;
	
	@Column(name = "Nr_CEP")
	private String cep;
	
	@Column(name = "Ds_Cidade")
	private String cidade;
	
	@Column(name = "Ds_Telefone")
	private String telefone;
	
	@Column(name = "Ds_Email")
	private String email;
	
	@Column(name = "Ds_Responsavel1")
	private String responsavel;
	
	public Transportadora() {
		
	}
	
	public Transportadora(String razaoSocial, String cnpj, String cpf, String cep, String cidade, String telefone, String email, String responsavel) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.cpf = cpf;
		this.cep = cep;
		this.cidade = cidade;
		this.telefone = telefone;
		this.email = email;
		this.responsavel = responsavel;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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
	
	
		
}
