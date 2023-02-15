package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbGalpaoLayout")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class GalpaoLayout {

	
	@GeneratedValue
	private Long id;
	@Id
	@Column(name = "fk_Id_Galpao")
	private Long idGalpao;

	@Column(name = "pk_Id_Bloco")
	private Long idBloco;

	@Column(name = "pk_Id_Posicao")
	private Long idPosicao;

	@Column(name = "pk_Id_Nivel")
	private Long idNivel;

	@Column(name = "Tam_Frente")
	private Float tamFrente;

	@Column(name = "Tam_Profun")
	private Float tamProfundidade;

	@Column(name = "Tam_Altura")
	private Float tamAltura;

	@Column(name = "pk_Id_Rua")
	private Long idRua = (long) 0;

	@Column(name = "fk_Id_Rua_Repoe")
	private Long idRuaRepoe = (long) 0;

	public GalpaoLayout() {

	}

	public GalpaoLayout(Long idGalpao, Long idBloco, Long idPosicao, Long idNivel, Float tamFrente,
			Float tamProfundidade, Float tamAltura, Long idRua, Long idRuaRepoe) {

		this.idGalpao = idGalpao;
		this.idBloco = idBloco;
		this.idPosicao = idPosicao;
		this.idNivel = idNivel;
		this.tamFrente = tamFrente;
		this.tamProfundidade = tamProfundidade;
		this.tamAltura = tamAltura;
		this.idRua = idRua;
		this.idRuaRepoe = idRuaRepoe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdGalpao() {
		return idGalpao;
	}

	public void setIdGalpao(Long idGalpao) {
		this.idGalpao = idGalpao;
	}

	public Long getIdBloco() {
		return idBloco;
	}

	public void setIdBloco(Long idBloco) {
		this.idBloco = idBloco;
	}

	public Long getIdPosicao() {
		return idPosicao;
	}

	public void setIdPosicao(Long idPosicao) {
		this.idPosicao = idPosicao;
	}

	public Long getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Long idNivel) {
		this.idNivel = idNivel;
	}

	public Float getTamFrente() {
		return tamFrente;
	}

	public void setTamFrente(Float tamFrente) {
		this.tamFrente = tamFrente;
	}

	public Float getTamProfundidade() {
		return tamProfundidade;
	}

	public void setTamProfundidade(Float tamProfundidade) {
		this.tamProfundidade = tamProfundidade;
	}

	public Float getTamAltura() {
		return tamAltura;
	}

	public void setTamAltura(Float tamAltura) {
		this.tamAltura = tamAltura;
	}

	public Long getIdRua() {
		return idRua;
	}

	public void setIdRua(Long idRua) {
		this.idRua = idRua;
	}

	public Long getIdRuaRepoe() {
		return idRuaRepoe;
	}

	public void setIdRuaRepoe(Long idRuaRepoe) {
		this.idRuaRepoe = idRuaRepoe;
	}

}
