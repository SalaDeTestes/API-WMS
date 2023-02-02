package com.wms.api.models;

/*Essa Tabela sera preenchida pelo service ControleRecebimentoService, no ato de inserção dos itens vindo do coletor, que se 
 * encontra no controller TarefaRecebimentoController, ela tambem é um atributo tipo Lista do modelo ControleRecebimento, que
 * é usado no controller citado*/
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbControleEntradaColetor")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ControleEntradaColetor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Identificador")
	private Long id;

	@Column(name = "pk_Id_Revisao")
	private Long revisao = (long) 1;

	@Column(name = "fk_Id_ControleEntrada")
	private Long idNotaFiscal;

	@Column(name = "fk_Id_Mercadoria")
	private Long idProduto;

	@Column(name = "fk_Id_Lote")
	private String lote;

	@Column(name = "fk_Id_Etiqueta")
	private Long idEtiqueta;

	@Column(name = "Ds_EtiquetaAT_Aux")
	private String descricaoEtiqueta;

	@Column(name = "Nr_NotaFiscal")
	private String numeroNota;

	@Column(name = "Nr_Carga")
	private String numeroCarga;

	@Column(name = "Nr_Doca")
	private Long idDoca;

	@Column(name = "Nr_Quant")
	private Float quantidade;

	@Column(name = "Dt_Validade")
	private LocalDate dataValidade;

	@Column(name = "Dt_Leitura")
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@Column(name = "Dt_Fabricacao")
	private LocalDate dataFabricacao;

	@Column(name = "fk_Id_TpPallet")
	private Long idTipoPallet = (long) 1;

	@Column(name = "Nr_Peso")
	private Float peso;

	@Column(name = "Nr_Pallet")
	private Integer numeroPallet;

	@Column(name = "fk_Id_Usuario")
	private Long idUsuario;

	@Column(name = "fg_Avaria")
	private Boolean avaria = false;

	@Column(name = "fg_Devolucao")
	private Boolean devolucao = false;

	@Column(name = "fg_Repal")
	private Boolean repal = false;

	@Column(name = "fg_Strech")
	private Boolean strech = false;

	public ControleEntradaColetor() {

	}

	public ControleEntradaColetor(Long revisao, Long idNotaFiscal, Long idProduto, String lote, Long idEtiqueta,
			String descricaoEtiqueta, String numeroNota, String numeroCarga, Long idDoca, Float quantidade,
			LocalDate dataValidade, LocalDateTime dataCadastro, LocalDate dataFabricacao, Long idTipoPallet, Float peso,
			Integer numeroPallet, Long idUsuario, Boolean avaria, Boolean devolucao, Boolean repal, Boolean strech) {

		this.revisao = revisao;
		this.idNotaFiscal = idNotaFiscal;
		this.idProduto = idProduto;
		this.lote = lote;
		this.idEtiqueta = idEtiqueta;
		this.descricaoEtiqueta = descricaoEtiqueta;
		this.numeroNota = numeroNota;
		this.numeroCarga = numeroCarga;
		this.idDoca = idDoca;
		this.quantidade = quantidade;
		this.dataValidade = dataValidade;
		this.dataCadastro = dataCadastro;
		this.dataFabricacao = dataFabricacao;
		this.idTipoPallet = idTipoPallet;
		this.peso = peso;
		this.numeroPallet = numeroPallet;
		this.idUsuario = idUsuario;
		this.avaria = avaria;
		this.devolucao = devolucao;
		this.repal = repal;
		this.strech = strech;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRevisao() {
		return revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
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

	public Long getIdEtiqueta() {
		return idEtiqueta;
	}

	public void setIdEtiqueta(Long idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public String getDescricaoEtiqueta() {
		return descricaoEtiqueta;
	}

	public void setDescricaoEtiqueta(String descricaoEtiqueta) {
		this.descricaoEtiqueta = descricaoEtiqueta;
	}

	public String getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	public String getNumeroCarga() {
		return numeroCarga;
	}

	public void setNumeroCarga(String numeroCarga) {
		this.numeroCarga = numeroCarga;
	}

	public Long getIdDoca() {
		return idDoca;
	}

	public void setIdDoca(Long idDoca) {
		this.idDoca = idDoca;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
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

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Long getIdTipoPallet() {
		return idTipoPallet;
	}

	public void setIdTipoPallet(Long idTipoPallet) {
		this.idTipoPallet = idTipoPallet;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Integer getNumeroPallet() {
		return numeroPallet;
	}

	public void setNumeroPallet(Integer numeroPallet) {
		this.numeroPallet = numeroPallet;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Boolean getAvaria() {
		return avaria;
	}

	public void setAvaria(Boolean avaria) {
		this.avaria = avaria;
	}

	public Boolean getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Boolean devolucao) {
		this.devolucao = devolucao;
	}

	public Boolean getRepal() {
		return repal;
	}

	public void setRepal(Boolean repal) {
		this.repal = repal;
	}

	public Boolean getStrech() {
		return strech;
	}

	public void setStrech(Boolean strech) {
		this.strech = strech;
	}

}
