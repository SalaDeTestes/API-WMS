package com.wms.api.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.wms.api.models.CategoriaGalpao;
import com.wms.api.models.Produto;
import com.wms.api.models.UnidadeMedida;
import com.wms.api.models.Usuario;

public class ProdutoDto {

	private Long id;
	private Usuario idUsuario;
	private UnidadeMedida idUnidadeMedida;
	private CategoriaGalpao idCategoriaGalpao;
	private String codigoFabricante;
	private String codigoProduto;
	private String descricao;
	private String nome;
	private String ean;
	private String dum;
	private Integer vidaUtil;
	private Float unidadePorPallet;
	private Integer quantidadeProdutoCaixa;
	private Float metroQuadrado;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizacao;
	private Float pesoLiquido;
	private Float pesoBruto;
	private Float pesoEmbalagem;
	private Integer lastroNormaPallet;
	private Integer alturaNormaPallet;
	private Float camadaNormaPallet;
	private Float alturaPallet;
	private Float larguraPallet;
	private Float comprimentoPallet;
	private Float alturaCaixa;
	private Float larguraCaixa;
	private Float comprimentoCaixa;
	private Float quantidadeMinima;
	private Boolean usaDataValidade;
	private Boolean usaDataFabricacao;
	private Boolean situacao;
	
	
	public ProdutoDto(Produto produto) {

		this.id = produto.getId();
		this.idUsuario = produto.getIdUsuario();
		this.idUnidadeMedida = produto.getIdUnidadeMedida();
		this.idCategoriaGalpao = produto.getIdCategoriaGalpao();
		this.codigoProduto = produto.getCodigoProduto();
		this.codigoFabricante = produto.getCodigoFabricante();
		this.descricao = produto.getDescricao();
		this.nome = produto.getNome();
		this.ean = produto.getEan();
		this.dum = produto.getDum();
		this.vidaUtil = produto.getVidaUtil();
		this.unidadePorPallet = produto.getUnidadePorPallet();
		this.quantidadeProdutoCaixa = produto.getQuantidadeProdutoCaixa();
		this.metroQuadrado = produto.getMetroQuadrado();
		this.dataCadastro = produto.getDataCadastro();
		this.dataAtualizacao = produto.getDataAtualizacao();
		this.pesoLiquido = produto.getPesoLiquido();
		this.pesoBruto = produto.getPesoBruto();
		this.pesoEmbalagem = produto.getPesoEmbalagem();
		this.lastroNormaPallet = produto.getLastroNormaPallet();
		this.alturaNormaPallet = produto.getAlturaNormaPallet();
		this.camadaNormaPallet = produto.getCamadaNormaPallet();
		this.alturaPallet = produto.getAlturaPallet();
		this.larguraPallet = produto.getLarguraPallet();
		this.comprimentoPallet = produto.getComprimentoPallet();
		this.comprimentoCaixa = produto.getComprimentoCaixa();
		this.alturaCaixa = produto.getAlturaCaixa();
		this.larguraCaixa = produto.getLarguraCaixa();
		this.quantidadeMinima = produto.getQuantidadeMinima();
		this.usaDataFabricacao = produto.getUsaDataFabricacao();
		this.usaDataValidade = produto.getUsaDataValidade();
		this.situacao = produto.getSituacao();
	}

	public Long getId() {
		return id;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public UnidadeMedida getIdUnidadeMedida() {
		return idUnidadeMedida;
	}

	public CategoriaGalpao getIdCategoriaGalpao() {
		return idCategoriaGalpao;
	}

	public String getCodigoFabricante() {
		return codigoFabricante;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getEan() {
		return ean;
	}

	public String getDum() {
		return dum;
	}

	public Integer getVidaUtil() {
		return vidaUtil;
	}

	public Float getUnidadePorPallet() {
		return unidadePorPallet;
	}

	public Integer getQuantidadeProdutoCaixa() {
		return quantidadeProdutoCaixa;
	}

	public Float getMetroQuadrado() {
		return metroQuadrado;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public Float getPesoLiquido() {
		return pesoLiquido;
	}

	public Float getPesoBruto() {
		return pesoBruto;
	}

	public Float getPesoEmbalagem() {
		return pesoEmbalagem;
	}

	public Integer getLastroNormaPallet() {
		return lastroNormaPallet;
	}

	public Integer getAlturaNormaPallet() {
		return alturaNormaPallet;
	}

	public Float getCamadaNormaPallet() {
		return camadaNormaPallet;
	}

	public Float getAlturaPallet() {
		return alturaPallet;
	}

	public Float getLarguraPallet() {
		return larguraPallet;
	}

	public Float getComprimentoPallet() {
		return comprimentoPallet;
	}

	public Float getAlturaCaixa() {
		return alturaCaixa;
	}

	public Float getLarguraCaixa() {
		return larguraCaixa;
	}

	public Float getComprimentoCaixa() {
		return comprimentoCaixa;
	}

	public Float getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public Boolean getUsaDataValidade() {
		return usaDataValidade;
	}

	public Boolean getUsaDataFabricacao() {
		return usaDataFabricacao;
	}

	public Boolean getSituacao() {
		return situacao;
	}


	public static List<ProdutoDto> converter(List<Produto> produto) {
		return produto.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}
}
