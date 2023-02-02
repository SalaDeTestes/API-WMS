package com.wms.api.models;

/*Essa Tabela sera preenchida pelo service ControleRecebimentoService, no ato de inserção dos itens vindo do coletor, que se 
 * encontra no controller TarefaRecebimentoController*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbControleEntradaMercadoriaPorPosicao")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ControleEntradaProdutoPorPosicao {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "fk_Id_ControleEntrada")
	private Long idNotaFiscal;

	@Column(name = "fk_Id_Mercadoria")
	private Long idProduto;

	@Column(name = "fk_Id_Lote")
	private String lote;

	@Column(name = "fk_Id_Galpao")
	private Long idGalpao;

	@Column(name = "fk_Id_Bloco")
	private Long idBloco = (long) 0;

	@Column(name = "fk_Id_Posicao")
	private Long idPosicao = (long) 0;

	@Column(name = "fk_Id_Nivel")
	private Long idNivel = (long) 0;

	@Column(name = "fk_Id_Rua")
	private Long idRua = (long) 0;

	@Column(name = "Qt_Unidade")
	private Float quantidade;

	@Column(name = "Qt_Pallets")
	private Integer quatidadePallets;

	@Column(name = "fk_Id_Etiqueta")
	private Long idEtiqueta;

	@Column(name = "fk_MotivoRetido")
	private Long idMotivoRetido;

	@Column(name = "fk_Id_StatusMov")
	private Long idStatusMovimentacao;

	@Column(name = "fk_Id_Usuario")
	private Long idUsuario;

	@Column(name = "Nr_SaidasEmAberto")
	private Integer numeroSaidasEmAberto = 0;

	@Column(name = "fg_Reserva")
	private Boolean reserva;

	public ControleEntradaProdutoPorPosicao() {

	}

	public ControleEntradaProdutoPorPosicao(Long idNotaFiscal, Long idProduto, String lote, Long idGalpao, Long idBloco,
			Long idPosicao, Long idNivel, Long idRua, Float quantidade, Integer quatidadePallets, Long idEtiqueta,
			Long idMotivoRetido, Long idStatusMovimentacao, Long idUsuario, Integer numeroSaidasEmAberto,
			Boolean reserva) {

		this.idNotaFiscal = idNotaFiscal;
		this.idProduto = idProduto;
		this.lote = lote;
		this.idGalpao = idGalpao;
		this.idBloco = idBloco;
		this.idPosicao = idPosicao;
		this.idNivel = idNivel;
		this.idRua = idRua;
		this.quantidade = quantidade;
		this.quatidadePallets = quatidadePallets;
		this.idEtiqueta = idEtiqueta;
		this.idMotivoRetido = idMotivoRetido;
		this.idStatusMovimentacao = idStatusMovimentacao;
		this.idUsuario = idUsuario;
		this.numeroSaidasEmAberto = numeroSaidasEmAberto;
		this.reserva = reserva;
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

	public Long getIdGalpao() {
		return idGalpao;
	}

	public void setIdGalpao(Long idGlapao) {
		this.idGalpao = idGlapao;
	}

	public Long getIdBloco() {
		return idBloco;
	}

	public void setIdBloco(Long idBloco) {
		this.idBloco = idBloco;
	}

	public Long getIdPosicao() {
		return idPosicao;
	}

	public void setIdPosicao(Long idPosicao) {
		this.idPosicao = idPosicao;
	}

	public Long getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Long idNivel) {
		this.idNivel = idNivel;
	}

	public Long getIdRua() {
		return idRua;
	}

	public void setIdRua(Long idRua) {
		this.idRua = idRua;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getQuatidadePallets() {
		return quatidadePallets;
	}

	public void setQuatidadePallets(Integer quatidadePallets) {
		this.quatidadePallets = quatidadePallets;
	}

	public Long getIdEtiqueta() {
		return idEtiqueta;
	}

	public void setIdEtiqueta(Long idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public Long getIdMotivoRetido() {
		return idMotivoRetido;
	}

	public void setIdMotivoRetido(Long idMotivoRetido) {
		this.idMotivoRetido = idMotivoRetido;
	}

	public Long getIdStatusMovimentacao() {
		return idStatusMovimentacao;
	}

	public void setIdStatusMovimentacao(Long idStatusMovimentacao) {
		this.idStatusMovimentacao = idStatusMovimentacao;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getNumeroSaidasEmAberto() {
		return numeroSaidasEmAberto;
	}

	public void setNumeroSaidasEmAberto(Integer numeroSaidasEmAberto) {
		this.numeroSaidasEmAberto = numeroSaidasEmAberto;
	}

	public Boolean getReserva() {
		return reserva;
	}

	public void setReserva(Boolean reserva) {
		this.reserva = reserva;
	}

}
