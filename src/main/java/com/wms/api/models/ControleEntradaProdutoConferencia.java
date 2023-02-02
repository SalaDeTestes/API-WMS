package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "tbControleEntradaMercadoriaConferencia")
public class ControleEntradaProdutoConferencia {

	@Id@GeneratedValue
	private Long id;
	
	@Column(name = "fk_Id_ControleEntrada")
	private Long idNotaFiscal;
	
	@Column(name = "fk_Id_Mercadoria")
	private Long idProduto;
	
	@Column(name = "fk_Id_Lote")
	private String lote;
	
	@Column(name = "fk_Id_Revisao")
	private Long revisao = (long) 1;

	@Column(name = "fk_Id_Usuario")
	private Long idUsuario;

	@Column(name = "Qt_Unidade")
	private Float quantidadeProduto;

	@Column(name = "Qt_Pallet")
	private Integer quantidadePallet;

	@Column(name = "Qt_Unidade_Conf_Entrada")
	private Float quantidadeProdutoConferida;

	@Column(name = "Qt_Pallet_Conf_Entrada")
	private Integer quantidadePalletConferida;

	@Column(name = "id_liberado_retido")
	private char idLiberadoRetido = 'L';

	public ControleEntradaProdutoConferencia() {

	}

	public ControleEntradaProdutoConferencia(Long idNotaFiscal, Long idProduto, String lote, Long revisao,
			Long idUsuario, Float quantidadeProduto, Integer quantidadePallet, Float quantidadeProdutoConferida,
			Integer quantidadePalletConferida, char idLiberadoRetido) {

		this.idNotaFiscal = idNotaFiscal;
		this.idProduto = idProduto;
		this.lote = lote;
		this.revisao = revisao;
		this.idUsuario = idUsuario;
		this.quantidadeProduto = quantidadeProduto;
		this.quantidadePallet = quantidadePallet;
		this.quantidadeProdutoConferida = quantidadeProdutoConferida;
		this.quantidadePalletConferida = quantidadePalletConferida;
		this.idLiberadoRetido = idLiberadoRetido;
	}

	public Long getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(Long idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Long getRevisao() {
		return revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Float getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Float quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Integer getQuantidadePallet() {
		return quantidadePallet;
	}

	public void setQuantidadePallet(Integer quantidadePallet) {
		this.quantidadePallet = quantidadePallet;
	}

	public Float getQuantidadeProdutoConferida() {
		return quantidadeProdutoConferida;
	}

	public void setQuantidadeProdutoConferida(Float quantidadeProdutoConferida) {
		this.quantidadeProdutoConferida = quantidadeProdutoConferida;
	}

	public Integer getQuantidadePalletConferida() {
		return quantidadePalletConferida;
	}

	public void setQuantidadePalletConferida(Integer quantidadePalletConferida) {
		this.quantidadePalletConferida = quantidadePalletConferida;
	}

	public char getIdLiberadoRetido() {
		return idLiberadoRetido;
	}

	public void setIdLiberadoRetido(char idLiberadoRetido) {
		this.idLiberadoRetido = idLiberadoRetido;
	}

}
