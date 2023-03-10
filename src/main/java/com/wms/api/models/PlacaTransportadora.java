package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbPlacaTransportadora")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PlacaTransportadora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Placa_Int")
	private Long id;

	@Column(name = "pk_Id_Placa")
	private String descricao;

	@JoinColumn(name = "fk_Id_Transportadora")
	@ManyToOne
	private Transportadora idTransportadora;

	@NotNull
	@Column(name = "fk_Uf_Placa")
	private Integer idUf;

	public PlacaTransportadora() {

	}

	public PlacaTransportadora(Transportadora idTransportadora, Integer idUf, String descricao) {

		this.idTransportadora = idTransportadora;
		this.idUf = idUf;
		this.descricao = descricao;
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

	public Integer getIdUf() {
		return idUf;
	}

	public void setIdUf(Integer idUf) {
		this.idUf = idUf;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
