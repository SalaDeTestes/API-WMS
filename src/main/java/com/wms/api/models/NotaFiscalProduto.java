package com.wms.api.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "tbControleEntradaMercadoria")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class NotaFiscalProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_Id_ControleEntrada")
	private NotaFiscal idNotaFiscal;

	@ManyToOne
	@JoinColumn(name = "fk_Id_Mercadoria")
	private Produto idProduto;

	@Column(name = "pk_Id_Lote")
	private String lote;

	@Column(name = "Qt_Unidade")
	private Float quantidadeProduto;

	@Column(name = "Qt_EstoqueLiberado")
	private Float estoqueLiberado;

	@Column(name = "Qt_EstoqueRetido")
	private Float estoqueRetido;

	@Column(name = "Qt_Pallets")
	private Float quantidadePalletsProduto;

	@Column(name = "Qt_EstoquePallets")
	private Float quantidadePalletsProdutoEstoque;

	@Column(name = "Nr_ValorUnitario")
	private Float valorUnitario;

	@Column(name = "PesoUnitario")
	private Float pesoUnitario;

	@Column(name = "Dt_Fabricacao")
	private LocalDate dataFabricacao;

	@Column(name = "Dt_Validade")
	private LocalDate dataValidade;

	@Column(name = "Dt_Cadastro")
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@Column(name = "Qt_Unidade_Conf_Entrada")
	private Float quantidadeUnidadeConferida;

	@Column(name = "Qt_Pallet_Conf_Entrada")
	private Float quantidadePalletProdutoConferido;

	public NotaFiscalProduto() {

	}

	public NotaFiscalProduto(NotaFiscal idNotaFiscal, Produto idProduto, String lote, Float quantidadeProduto,
			Float estoqueLiberado, Float estoqueRetido, Float quantidadePalletsProduto,
			Float quantidadePalletsProdutoEstoque, Float valorUnitario, Float pesoUnitario, LocalDate dataFabricacao,
			LocalDate dataValidade, Float quantidadeUnidadeConferida, Float quantidadePalletProdutoConferido,
			LocalDateTime dataCadastro) {

		this.idNotaFiscal = idNotaFiscal;
		this.idProduto = idProduto;
		this.lote = lote;
		this.quantidadeProduto = quantidadeProduto;
		this.estoqueLiberado = estoqueLiberado;
		this.estoqueRetido = estoqueRetido;
		this.quantidadePalletsProduto = quantidadePalletsProduto;
		this.quantidadePalletsProdutoEstoque = quantidadePalletsProdutoEstoque;
		this.valorUnitario = valorUnitario;
		this.pesoUnitario = pesoUnitario;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.dataCadastro = dataCadastro;
		this.quantidadeUnidadeConferida = quantidadeUnidadeConferida;
		this.quantidadePalletProdutoConferido = quantidadePalletProdutoConferido;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NotaFiscal getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(NotaFiscal idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

	public Produto getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Float getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Float quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
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

	public Float getQuantidadePalletsProduto() {
		return quantidadePalletsProduto;
	}

	public void setQuantidadePalletsProduto(Float quantidadePalletsProduto) {
		this.quantidadePalletsProduto = quantidadePalletsProduto;
	}

	public Float getQuantidadePalletsProdutoEstoque() {
		return quantidadePalletsProdutoEstoque;
	}

	public void setQuantidadePalletsProdutoEstoque(Float quantidadePalletsProdutoEstoque) {
		this.quantidadePalletsProdutoEstoque = quantidadePalletsProdutoEstoque;
	}

	public Float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Float getPesoUnitario() {
		return pesoUnitario;
	}

	public void setPesoUnitario(Float pesoUnitario) {
		this.pesoUnitario = pesoUnitario;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Float getQuantidadeUnidadeConferida() {
		return quantidadeUnidadeConferida;
	}

	public void setQuantidadeUnidadeConferida(Float quantidadeUnidadeConferida) {
		this.quantidadeUnidadeConferida = quantidadeUnidadeConferida;
	}

	public Float getQuantidadePalletProdutoConferido() {
		return quantidadePalletProdutoConferido;
	}

	public void setQuantidadePalletProdutoConferido(Float quantidadePalletProdutoConferido) {
		this.quantidadePalletProdutoConferido = quantidadePalletProdutoConferido;
	}

}
