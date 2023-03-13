package com.wms.api.controller.dto;

import java.time.LocalDate;

import com.wms.api.models.ControleEntradaProdutoPorPosicao;
import com.wms.api.models.NotaFiscalProduto;

public class LiberarReterDto {

	private Long idNotaFiscalProduto;
	private Long idNotaFiscal;
	private Long idProduto;
	private String lote;
	private Float quantidadeProduto;
	private Float estoqueLiberado;
	private Float estoqueRetido;
	private LocalDate dataFabricacao;
	private LocalDate dataValidade;
	private Long idEtiqueta;
	private Long idGalpao;
	private Long idBloco;
	private Long idNivel;
	private Long idPosicao;
	private String Status;
	private String codigoProduto;
	private String descricaoProduto;

	public LiberarReterDto(NotaFiscalProduto nfProduto, ControleEntradaProdutoPorPosicao porPosicao) {
		this.idNotaFiscalProduto = nfProduto.getId();
		this.idNotaFiscal = nfProduto.getIdNotaFiscal().getId();
		this.idProduto = nfProduto.getIdProduto().getId();
		this.lote = nfProduto.getLote();
		this.quantidadeProduto = nfProduto.getQuantidadeProduto();
		this.estoqueLiberado = nfProduto.getEstoqueLiberado();
		this.estoqueRetido = nfProduto.getEstoqueRetido();
		this.dataFabricacao = nfProduto.getDataFabricacao();
		this.dataValidade = nfProduto.getDataValidade();
		this.idEtiqueta = porPosicao.getIdEtiqueta();
		this.idGalpao = porPosicao.getIdGalpao();
		this.idBloco = porPosicao.getIdBloco();
		this.idNivel = porPosicao.getIdNivel();
		this.idPosicao = porPosicao.getIdPosicao();
		this.codigoProduto = porPosicao.getIdProduto().getCodigoFabricante();
		this.descricaoProduto = porPosicao.getIdProduto().getDescricao();
		
		if (nfProduto.getEstoqueLiberado() == null || nfProduto.getEstoqueLiberado() == 0
				|| nfProduto.getEstoqueLiberado() < 0) {
			this.Status = "Retido";
		} else if (nfProduto.getEstoqueRetido() == null || nfProduto.getEstoqueRetido() == 0
				|| nfProduto.getEstoqueRetido() < 0) {
			this.Status = "Liberado";
		}
	}

	public Long getIdNotaFiscalProduto() {
		return idNotaFiscalProduto;
	}

	public void setIdNotaFiscalProduto(Long idNotaFiscalProduto) {
		this.idNotaFiscalProduto = idNotaFiscalProduto;
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

	public Long getIdEtiqueta() {
		return idEtiqueta;
	}

	public void setIdEtiqueta(Long idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
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

	public Long getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Long idNivel) {
		this.idNivel = idNivel;
	}

	public Long getIdPosicao() {
		return idPosicao;
	}

	public void setIdPosicao(Long idPosicao) {
		this.idPosicao = idPosicao;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

}
