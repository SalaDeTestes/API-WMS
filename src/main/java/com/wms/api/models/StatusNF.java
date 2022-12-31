package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbStatusNotaFiscalEntrada")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StatusNF {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_StatusNFEntrada")
	private Long id;
	
	@Column(name = "ds_Status")
	private String descricaoStatus;
	
	public StatusNF() {
		
	}
	
	public StatusNF(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoStatus() {
		return descricaoStatus;
	}

	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}
		    
	
}
