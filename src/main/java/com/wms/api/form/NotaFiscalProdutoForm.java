package com.wms.api.form;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.wms.api.models.NotaFiscalProduto;
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;
import com.wms.api.repository.ProdutoRepository;

public class NotaFiscalProdutoForm {

	private Long idNotaFiscal;
	private Long idProduto;
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
	
	public NotaFiscalProduto formulario(NotaFiscalRepository nfRepository, ProdutoRepository produtoRepository) {
		
		NotaFiscalProduto nfProduto = new NotaFiscalProduto();
		
		nfProduto.setIdNotaFiscal(nfRepository.getReferenceById(idNotaFiscal));
		nfProduto.setIdProduto(produtoRepository.getReferenceById(idProduto));
		nfProduto.setLote(lote);
		nfProduto.setQuantidadeProduto(quantidadeProduto);
		nfProduto.setQuantidadePalletsProduto(quantidadePalletsProduto);
		nfProduto.setQuantidadePalletsProdutoEstoque(quantidadePalletsProdutoEstoque);
		nfProduto.setQuantidadePalletProdutoConferido(quantidadePalletProdutoConferido);
		nfProduto.setValorUnitario(valorUnitario);
		nfProduto.setEstoqueRetido(estoqueRetido);
		nfProduto.setEstoqueLiberado(quantidadeProduto);
		nfProduto.setPesoUnitario(pesoUnitario);
		nfProduto.setDataFabricacao(dataFabricacao);
		nfProduto.setDataValidade(dataValidade);
		nfProduto.setQuantidadeUnidadeConferida(quantidadeUnidadeConferida);
		return nfProduto;
	}
	
public NotaFiscalProduto atualizar(Long id, NotaFiscalProdutoRepository nfprodutoRepoditory, NotaFiscalRepository nfRepository, ProdutoRepository produtoRepository) {
		
		NotaFiscalProduto nfProduto = nfprodutoRepoditory.getReferenceById(id);
		
		nfProduto.setIdNotaFiscal(nfRepository.getReferenceById(idNotaFiscal));
		nfProduto.setIdProduto(produtoRepository.getReferenceById(idProduto));
		nfProduto.setLote(lote);
		nfProduto.setQuantidadeProduto(quantidadeProduto);
		nfProduto.setQuantidadePalletsProduto(quantidadePalletsProduto);
		nfProduto.setQuantidadePalletsProdutoEstoque(quantidadePalletsProdutoEstoque);
		nfProduto.setQuantidadePalletProdutoConferido(quantidadePalletProdutoConferido);
		nfProduto.setValorUnitario(valorUnitario);
		nfProduto.setEstoqueRetido(estoqueRetido);
		nfProduto.setEstoqueLiberado(quantidadeProduto);
		nfProduto.setPesoUnitario(pesoUnitario);
		nfProduto.setDataFabricacao(dataFabricacao);
		nfProduto.setDataValidade(dataValidade);
		nfProduto.setQuantidadeUnidadeConferida(quantidadeUnidadeConferida);
		return nfProduto;
	}
}
