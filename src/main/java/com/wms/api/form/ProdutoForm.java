package com.wms.api.form;

import java.time.LocalDateTime;

import com.wms.api.models.Produto;
import com.wms.api.repository.CategoriaGalpaoRepository;
import com.wms.api.repository.ProdutoRepository;
import com.wms.api.repository.UnidadeMedidaRepository;
import com.wms.api.repository.UsuarioRepository;

public class ProdutoForm {

	private Long idUsuario;
	private Integer idUnidadeMedida;
	private Long idCategoriaGalpao;
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
	private Integer diasCriterioRecebimento;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdUnidadeMedida() {
		return idUnidadeMedida;
	}

	public void setIdUnidadeMedida(Integer idUnidadeMedida) {
		this.idUnidadeMedida = idUnidadeMedida;
	}

	public Long getIdCategoriaGalpao() {
		return idCategoriaGalpao;
	}

	public void setIdCategoriaGalpao(Long idCategoriaGalpao) {
		this.idCategoriaGalpao = idCategoriaGalpao;
	}

	public String getCodigoFabricante() {
		return codigoFabricante;
	}

	public void setCodigoFabricante(String codFabricante) {
		this.codigoFabricante = codFabricante;
	}

	public String getCodProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codProduto) {
		this.codigoProduto = codProduto;
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

	public Integer getDiasCriterioRecebimento() {
		return diasCriterioRecebimento;
	}

	public void setDiasCriterioRecebimento(Integer diasCriterioRecebimento) {
		this.diasCriterioRecebimento = diasCriterioRecebimento;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public Produto formulario(UsuarioRepository usuarioRepository, UnidadeMedidaRepository medidaRepository,
			CategoriaGalpaoRepository categoriaGalpaoRepository) {

		Produto produto = new Produto();

		produto.setIdUsuario(usuarioRepository.getReferenceById(idUsuario));
		produto.setIdUnidadeMedida(medidaRepository.getReferenceById(idUnidadeMedida));
		produto.setIdCategoriaGalpao(categoriaGalpaoRepository.getReferenceById(idCategoriaGalpao));
		produto.setCodigoProduto(codigoProduto);
		produto.setCodigoFabricante(codigoFabricante);
		produto.setDescricao(descricao);
		produto.setNome(nome);
		produto.setEan(ean);
		produto.setDum(dum);
		produto.setVidaUtil(vidaUtil);
		produto.setUnidadePorPallet(unidadePorPallet);
		produto.setQuantidadeProdutoCaixa(quantidadeProdutoCaixa);
		produto.setMetroQuadrado(metroQuadrado);
		produto.setDataAtualizacao(dataAtualizacao);
		produto.setPesoLiquido(pesoLiquido);
		produto.setPesoBruto(pesoBruto);
		produto.setPesoEmbalagem(pesoEmbalagem);
		produto.setLastroNormaPallet(lastroNormaPallet);
		produto.setAlturaNormaPallet(alturaNormaPallet);
		produto.setCamadaNormaPallet(camadaNormaPallet);
		produto.setAlturaPallet(alturaPallet);
		produto.setLarguraPallet(larguraPallet);
		produto.setComprimentoPallet(comprimentoPallet);
		produto.setComprimentoCaixa(comprimentoCaixa);
		produto.setAlturaCaixa(alturaCaixa);
		produto.setLarguraCaixa(larguraCaixa);
		produto.setQuantidadeMinima(quantidadeMinima);
		produto.setUsaDataFabricacao(usaDataFabricacao);
		produto.setUsaDataValidade(usaDataValidade);
		produto.setSituacao(situacao);
		produto.setDiasCriterioRecebimento(diasCriterioRecebimento);
		produto.setCodigoProduto(codigoProduto);

		return produto;

	}

	public Produto atualizar(Long id, ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository,
			UnidadeMedidaRepository medidaRepository, CategoriaGalpaoRepository categoriaGalpaoRepository) {

		Produto produto = produtoRepository.getReferenceById(id);

		produto.setIdUsuario(usuarioRepository.getReferenceById(idUsuario));
		produto.setIdUnidadeMedida(medidaRepository.getReferenceById(idUnidadeMedida));
		produto.setIdCategoriaGalpao(categoriaGalpaoRepository.getReferenceById(idCategoriaGalpao));
		produto.setCodigoProduto(codigoProduto);
		produto.setCodigoFabricante(codigoFabricante);
		produto.setDescricao(descricao);
		produto.setNome(nome);
		produto.setEan(ean);
		produto.setDum(dum);
		produto.setVidaUtil(vidaUtil);
		produto.setUnidadePorPallet(unidadePorPallet);
		produto.setQuantidadeProdutoCaixa(quantidadeProdutoCaixa);
		produto.setMetroQuadrado(metroQuadrado);
		produto.setDataAtualizacao(dataAtualizacao);
		produto.setPesoLiquido(pesoLiquido);
		produto.setPesoBruto(pesoBruto);
		produto.setPesoEmbalagem(pesoEmbalagem);
		produto.setLastroNormaPallet(lastroNormaPallet);
		produto.setAlturaNormaPallet(alturaNormaPallet);
		produto.setCamadaNormaPallet(camadaNormaPallet);
		produto.setAlturaPallet(alturaPallet);
		produto.setLarguraPallet(larguraPallet);
		produto.setComprimentoPallet(comprimentoPallet);
		produto.setComprimentoCaixa(comprimentoCaixa);
		produto.setAlturaCaixa(alturaCaixa);
		produto.setLarguraCaixa(larguraCaixa);
		produto.setQuantidadeMinima(quantidadeMinima);
		produto.setUsaDataFabricacao(usaDataFabricacao);
		produto.setUsaDataValidade(usaDataValidade);
		produto.setSituacao(situacao);
		produto.setDiasCriterioRecebimento(diasCriterioRecebimento);
		produto.setCodigoProduto(codigoProduto);

		return produto;

	}

}
