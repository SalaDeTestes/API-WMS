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
@Table(name = "tbControleEntradaMercadoriaHistorico")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class NotaFiscalProdutoHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fk_Id_ControleEntrada")
	private Long idNotaFiscal;

	@Column(name = "fk_Id_Mercadoria")
	private Long idProduto;

	@Column(name = "pk_Id_Lote")
	private String lote;

	@Column(name = "Qt_EstoqueLiberado")
	private Float estoqueLiberado;

	@Column(name = "Qt_EstoqueRetido")
	private Float estoqueRetido;

	@Column(name = "Qt_Unidade")
	private Float quantidadeProduto;

	@Column(name = "Qt_Pallets")
	private Integer quantidadePallet;

	@Column(name = "Qt_EstoquePallets")
	private Integer quantidadeEstoquePallet;

	@Column(name = "Qt_Unidade_Conf_Entrada")
	private Float quantidadeProdutoConferida;

	@Column(name = "Qt_Pallet_Conf_Entrada")
	private Float quantidadePalletConferido;

	@Column(name = "Nr_ValorUnitario")
	private Float valorUnitario;

	@Column(name = "PesoUnitario")
	private Float peso;

	@Column(name = "Dt_Cadastro")
	private LocalDateTime dataCadastro = LocalDateTime.now();

	public NotaFiscalProdutoHistorico() {

	}

	public NotaFiscalProdutoHistorico(Long idNotaFiscal, Long idProduto, String lote, Float estoqueLiberado,
			Float estoqueRetido, Float quantidadeProduto, Integer quantidadePallet, Integer quantidadeEstoquePallet,
			Float quantidadeProdutoConferida, Float quantidadePalletConferido, Float valorUnitario, Float peso,
			LocalDateTime dataCadastro) {

		this.idNotaFiscal = idNotaFiscal;
		this.idProduto = idProduto;
		this.lote = lote;
		this.estoqueLiberado = estoqueLiberado;
		this.estoqueRetido = estoqueRetido;
		this.quantidadeProduto = quantidadeProduto;
		this.quantidadePallet = quantidadePallet;
		this.quantidadeEstoquePallet = quantidadeEstoquePallet;
		this.quantidadeProdutoConferida = quantidadeProdutoConferida;
		this.quantidadePalletConferido = quantidadePalletConferido;
		this.valorUnitario = valorUnitario;
		this.peso = peso;
		this.dataCadastro = dataCadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Float getEstoqueLiberado() {
		return estoqueLiberado;
	}

	public void setEstoqueLiberado(Float estoqueLiberado) {
		this.estoqueLiberado = estoqueLiberado;
	}

	public Float getEstoqueRetido() {
		return estoqueRetido;
	}

	public void setEstoqueRetido(Float estoqueRetido) {
		this.estoqueRetido = estoqueRetido;
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

	public Integer getQuantidadeEstoquePallet() {
		return quantidadeEstoquePallet;
	}

	public void setQuantidadeEstoquePallet(Integer quantidadeEstoquePallet) {
		this.quantidadeEstoquePallet = quantidadeEstoquePallet;
	}

	public Float getQuantidadeProdutoConferida() {
		return quantidadeProdutoConferida;
	}

	public void setQuantidadeProdutoConferida(Float quantidadeProdutoConferida) {
		this.quantidadeProdutoConferida = quantidadeProdutoConferida;
	}

	public Float getQuantidadePalletConferido() {
		return quantidadePalletConferido;
	}

	public void setQuantidadePalletConferido(Float quantidadePalletConferido) {
		this.quantidadePalletConferido = quantidadePalletConferido;
	}

	public Float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
