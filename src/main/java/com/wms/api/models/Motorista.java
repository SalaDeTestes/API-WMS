package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbMotorista")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Motorista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Motorista")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_Id_Transportadora")
	private Transportadora idTransportadora;

	@Column(name = "Nm_Motorista")
	private String nome;

	@Column(name = "Nr_CPF")
	private String cpf;

	@Column(name = "Ds_Celular")
	private String celular;

	public Motorista() {

	}

	public Motorista(Transportadora idTransportadora, String nome, String cpf, String celular) {
		this.idTransportadora = idTransportadora;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Transportadora getIdTransportadora() {
		return idTransportadora;
	}

	public void setIdTransportadora(Transportadora idTransportadora) {
		this.idTransportadora = idTransportadora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
