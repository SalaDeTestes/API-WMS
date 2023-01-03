package com.wms.api.models;

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
@Table(name = "tbMercadoria")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Mercadoria")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_Id_Usuario")
	private Usuario idUsuario;

	@ManyToOne
	@JoinColumn(name = "fk_Id_UnidadeTrabalhada")
	private UnidadeMedida idUnidadeMedida;

	@ManyToOne
	@JoinColumn(name = "fk_Id_CategGalpao")
	private CategoriaGalpao idCategoriaGalpao;

	@Column(name = "Ds_CodigoFabricante")
	private String codigoFabricante;

	@Column(name = "Ds_CodigoMercadoria")
	private String codigoProduto;

	@Column(name = "Ds_Mercadoria")
	private String descricao;

	@Column(name = "Ds_Apelido")
	private String nome;

	@Column(name = "Nr_EAN")
	private String ean;

	@Column(name = "Nr_DUM")
	private String dum;

	@Column(name = "Qt_DiasVidaUtil")
	private Integer vidaUtil;

	@Column(name = "Qt_UnidadePorPallet")
	private Float unidadePorPallet;

	@Column(name = "Qt_Embalagem")
	private Integer quantidadeProdutoCaixa;

	@Column(name = "Pc_ConversaoMt2")
	private Float metroQuadrado;

	@Column(name = "Dt_Cadastro")
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@Column(name = "Dt_Atualizacao")
	private LocalDateTime dataAtualizacao;

	@Column(name = "Pc_ConversaoPesoLiquido")
	private Float pesoLiquido;

	@Column(name = "Pc_ConversaoPesoBruto")
	private Float pesoBruto;

	@Column(name = "Pc_ConversaoPesoEmbalagem")
	private Float pesoEmbalagem;
	// inicio norma de palletização
	@Column(name = "nr_mercadoriaLastro")
	private Integer lastroNormaPallet;

	@Column(name = "nr_mercadoriaAltura")
	private Integer alturaNormaPallet;

	@Column(name = "Nr_Camada")
	private Float camadaNormaPallet;
	// fim norma de palletização
	@Column(name = "nr_Altura")
	private Float alturaPallet;

	@Column(name = "nr_largura")
	private Float larguraPallet;

	@Column(name = "nr_Profundidade")
	private Float comprimentoPallet;

	@Column(name = "Nr_AlturaCaixa")
	private Float alturaCaixa;

	@Column(name = "Nr_LarguraCaixa")
	private Float larguraCaixa;

	@Column(name = "Nr_ProfunidadeCaixa")
	private Float comprimentoCaixa;

	@Column(name = "Qt_MinimaEstoque")
	private Float quantidadeMinima;

	@Column(name = "fg_DataValidade") // Usa data de validade para medir a vida util
	private Boolean usaDataValidade;

	@Column(name = "fg_DataFabricacao") // Usa data de fabricação para medir a vida util
	private Boolean usaDataFabricacao;

	@Column(name = "fg_Status") // Produto ativo ou inativo
	private Boolean situacao;

	// 32 campos

	public Produto() {

	}

	public Produto(Usuario idUsuario, UnidadeMedida idUnidadeMedida, CategoriaGalpao idCategoriaGalpao,
			String codProduto, String codFabricante, String descricao, String nome, String ean, String dum,
			Integer vidaUtil, Float unidadePorPallet, Integer quantidadeProdutoCaixa, Float metroQuadrado,
			LocalDateTime dataCadastro, LocalDateTime dataAtualizacao, Float pesoLiquido, Float pesoBruto,
			Float pesoEmbalagem, Integer lastroNormaPallet, Integer alturaNormaPallet, Float camadaNormaPallet,
			Float alturaPallet, Float larguraPallet, Float comprimentoPallet, Float comprimentoCaixa, Float alturaCaixa,
			Float larguraCaixa, Float quantidadeMinima, Boolean usaDataFabricacao, Boolean usaDataValidade,
			Boolean situacao) {

		this.idUsuario = idUsuario;
		this.idUnidadeMedida = idUnidadeMedida;
		this.idCategoriaGalpao = idCategoriaGalpao;
		this.codigoProduto = codProduto;
		this.codigoFabricante = codFabricante;
		this.descricao = descricao;
		this.nome = nome;
		this.ean = ean;
		this.dum = dum;
		this.vidaUtil = vidaUtil;
		this.unidadePorPallet = unidadePorPallet;
		this.quantidadeProdutoCaixa = quantidadeProdutoCaixa;
		this.metroQuadrado = metroQuadrado;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.pesoLiquido = pesoLiquido;
		this.pesoBruto = pesoBruto;
		this.pesoEmbalagem = pesoEmbalagem;
		this.lastroNormaPallet = lastroNormaPallet;
		this.alturaNormaPallet = alturaNormaPallet;
		this.camadaNormaPallet = camadaNormaPallet;
		this.alturaPallet = alturaPallet;
		this.larguraPallet = larguraPallet;
		this.comprimentoPallet = comprimentoPallet;
		this.comprimentoCaixa = comprimentoCaixa;
		this.alturaCaixa = alturaCaixa;
		this.larguraCaixa = larguraCaixa;
		this.quantidadeMinima = quantidadeMinima;
		this.usaDataFabricacao = usaDataFabricacao;
		this.usaDataValidade = usaDataValidade;
		this.situacao = situacao;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public UnidadeMedida getIdUnidadeMedida() {
		return idUnidadeMedida;
	}

	public void setIdUnidadeMedida(UnidadeMedida idUnidadeMedida) {
		this.idUnidadeMedida = idUnidadeMedida;
	}

	public CategoriaGalpao getIdCategoriaGalpao() {
		return idCategoriaGalpao;
	}

	public void setIdCategoriaGalpao(CategoriaGalpao idCategoriaGalpao) {
		this.idCategoriaGalpao = idCategoriaGalpao;
	}

	public String getCodigoFabricante() {
		return codigoFabricante;
	}

	public void setCodigoFabricante(String codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getDum() {
		return dum;
	}

	public void setDum(String dum) {
		this.dum = dum;
	}

	public Integer getVidaUtil() {
		return vidaUtil;
	}

	public void setVidaUtil(Integer vidaUtil) {
		this.vidaUtil = vidaUtil;
	}

	public Float getUnidadePorPallet() {
		return unidadePorPallet;
	}

	public void setUnidadePorPallet(Float unidadePorPallet) {
		this.unidadePorPallet = unidadePorPallet;
	}

	public Integer getQuantidadeProdutoCaixa() {
		return quantidadeProdutoCaixa;
	}

	public void setQuantidadeProdutoCaixa(Integer quantidadeProdutoCaixa) {
		this.quantidadeProdutoCaixa = quantidadeProdutoCaixa;
	}

	public Float getMetroQuadrado() {
		return metroQuadrado;
	}

	public void setMetroQuadrado(Float metroQuadrado) {
		this.metroQuadrado = metroQuadrado;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Float getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(Float pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public Float getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(Float pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public Float getPesoEmbalagem() {
		return pesoEmbalagem;
	}

	public void setPesoEmbalagem(Float pesoEmbalagem) {
		this.pesoEmbalagem = pesoEmbalagem;
	}

	public Integer getLastroNormaPallet() {
		return lastroNormaPallet;
	}

	public void setLastroNormaPallet(Integer lastroNormaPallet) {
		this.lastroNormaPallet = lastroNormaPallet;
	}

	public Integer getAlturaNormaPallet() {
		return alturaNormaPallet;
	}

	public void setAlturaNormaPallet(Integer alturaNormaPallet) {
		this.alturaNormaPallet = alturaNormaPallet;
	}

	public Float getCamadaNormaPallet() {
		return camadaNormaPallet;
	}

	public void setCamadaNormaPallet(Float camadaNormaPallet) {
		this.camadaNormaPallet = camadaNormaPallet;
	}

	public Float getAlturaPallet() {
		return alturaPallet;
	}

	public void setAlturaPallet(Float alturaPallet) {
		this.alturaPallet = alturaPallet;
	}

	public Float getLarguraPallet() {
		return larguraPallet;
	}

	public void setLarguraPallet(Float larguraPallet) {
		this.larguraPallet = larguraPallet;
	}

	public Float getComprimentoPallet() {
		return comprimentoPallet;
	}

	public void setComprimentoPallet(Float comprimentoPallet) {
		this.comprimentoPallet = comprimentoPallet;
	}

	public Float getAlturaCaixa() {
		return alturaCaixa;
	}

	public void setAlturaCaixa(Float alturaCaixa) {
		this.alturaCaixa = alturaCaixa;
	}

	public Float getLarguraCaixa() {
		return larguraCaixa;
	}

	public void setLarguraCaixa(Float larguraCaixa) {
		this.larguraCaixa = larguraCaixa;
	}

	public Float getComprimentoCaixa() {
		return comprimentoCaixa;
	}

	public void setComprimentoCaixa(Float comprimentoCaixa) {
		this.comprimentoCaixa = comprimentoCaixa;
	}

	public Float getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(Float quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	public Boolean getUsaDataValidade() {
		return usaDataValidade;
	}

	public void setUsaDataValidade(Boolean usaDataValidade) {
		this.usaDataValidade = usaDataValidade;
	}

	public Boolean getUsaDataFabricacao() {
		return usaDataFabricacao;
	}

	public void setUsaDataFabricacao(Boolean usaDataFabricacao) {
		this.usaDataFabricacao = usaDataFabricacao;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

}
