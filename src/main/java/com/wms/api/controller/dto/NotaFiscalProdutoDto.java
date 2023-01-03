package com.wms.api.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.wms.api.models.NotaFiscal;
import com.wms.api.models.NotaFiscalProduto;
import com.wms.api.models.Produto;

public class NotaFiscalProdutoDto {

	private Long id;
	private NotaFiscal idNotaFiscal;
	private Produto idProduto;
	private String lote;
	private Float quantidadeProduto;
	private Float estoqueLiberado;
	private Float estoqueRetido;
	private Float quantidadePalletsProduto;
	private Float quantidadePalletsProdutoEstoque;
	private Float valorUnitario;
	private Float pesoUnitario;
	private LocalDate dataFabricacao;
	private LocalDate dataValidade;
	private LocalDateTime dataCadastro;
	private Float quantidadeUnidadeConferida;
	private Float quantidadePalletProdutoConferido;

	public NotaFiscalProdutoDto(NotaFiscalProduto nfproduto) {
		this.id = nfproduto.getId();
		this.idNotaFiscal = nfproduto.getIdNotaFiscal();
		this.idProduto = nfproduto.getIdProduto();
		this.lote = nfproduto.getLote();
		this.quantidadeProduto = nfproduto.getQuantidadeProduto();
		this.estoqueLiberado = nfproduto.getEstoqueLiberado();
		this.estoqueRetido = nfproduto.getEstoqueRetido();
		this.quantidadePalletsProduto = nfproduto.getQuantidadePalletsProduto();
		this.quantidadePalletsProdutoEstoque = nfproduto.getQuantidadePalletsProdutoEstoque();
		this.quantidadePalletProdutoConferido = nfproduto.getQuantidadePalletProdutoConferido();
		this.valorUnitario = nfproduto.getValorUnitario();
		this.pesoUnitario = nfproduto.getPesoUnitario();
		this.dataFabricacao = nfproduto.getDataFabricacao();
		this.dataFabricacao = nfproduto.getDataFabricacao();
		this.dataCadastro = nfproduto.getDataCadastro();
		this.quantidadeUnidadeConferida = nfproduto.getQuantidadeUnidadeConferida();

	}

	public Long getId() {
		return id;
	}

	public NotaFiscal getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public Produto getIdProduto() {
		return idProduto;
	}

	public String getLote() {
		return lote;
	}

	public Float getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public Float getEstoqueLiberado() {
		return estoqueLiberado;
	}

	public Float getEstoqueRetido() {
		return estoqueRetido;
	}

	public Float getQuantidadePalletsProduto() {
		return quantidadePalletsProduto;
	}

	public Float getQuantidadePalletsProdutoEstoque() {
		return quantidadePalletsProdutoEstoque;
	}

	public Float getValorUnitario() {
		return valorUnitario;
	}

	public Float getPesoUnitario() {
		return pesoUnitario;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public Float getQuantidadeUnidadeConferida() {
		return quantidadeUnidadeConferida;
	}

	public Float getQuantidadePalletProdutoConferido() {
		return quantidadePalletProdutoConferido;
	}

	public static List<NotaFiscalProdutoDto> converter(List<NotaFiscalProduto> nfproduto) {

		return nfproduto.stream().map(NotaFiscalProdutoDto::new).collect(Collectors.toList());
	}
}
