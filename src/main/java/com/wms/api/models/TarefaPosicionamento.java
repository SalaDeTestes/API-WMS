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
@Table(name = "tbTarefa")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TarefaPosicionamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Tarefa")
	private Long id;

	@Column(name = "fk_Id_Cliente")
	private Long idCliente;

	@Column(name = "fk_Id_StatusTarefa")
	private Long idStatusTarefa;

	@Column(name = "fk_Id_TipoTarefa")
	private Long idTipoTarefa;

	@Column(name = "fk_Id_UsuarioCriador")
	private Long idUsuario;

	@Column(name = "fk_Id_EquipCriador")
	private Long idEquipeCriador;

	@Column(name = "fk_Id_UserMov")
	private Long idUsuarioMov;

	@Column(name = "fk_Id_EquipExec")
	private Long idEquipeExec;

	@Column(name = "fk_Tipo_Equip")
	private Long idTipoEquipe;

	@Column(name = "Dt_Criacao_Tarefa")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(name = "Dt_Hora_Ini")
	private LocalDateTime dataInicio;

	@Column(name = "Dt_Hora_Fim")
	private LocalDateTime dataFim;

	@Column(name = "Nr_Qt_Mercadoria")
	private Float qtdProduto;

	@Column(name = "Nr_Qt_MercadoriaRestante")
	private Float qtdProdutoRestante;

	@Column(name = "Nr_Seq_Prioridade")
	private Integer nrSeqPrioridade;

	@Column(name = "Nr_Seq_OrdemTarefa")
	private Integer nrSeqOrdemTarefa;

	@Column(name = "Nr_Seq_TarefaPai")
	private Long nrSeqTarefaPai;

	@Column(name = "fk_Id_Galpao_Origem")
	private Long idGalpaoOrigem;

	@Column(name = "fk_Id_Bloco_Origem")
	private Long idBlocoOrigem;

	@Column(name = "fk_Id_Posicao_Origem")
	private Long idPosicaoOrigem;

	@Column(name = "fk_Id_Nivel_Origem")
	private Long idNivelOrigem;

	@Column(name = "fk_Id_Galpao_Dest")
	private Long idGalpaoDestino;

	@Column(name = "fk_Id_Bloco_Dest")
	private Long idBlocoDestino;

	@Column(name = "fk_Id_Posicao_Dest")
	private Long idPosicaoDestino;

	@Column(name = "fk_Id_Nivel_Dest")
	private Long idNivelDestino;

	@Column(name = "fk_Id_Etiqueta")
	private Long idEtiqueta;

	@Column(name = "fk_Id_ControleEntrada")
	private Long idNotaFiscal;

	@Column(name = "fk_Id_Mercadoria")
	private Long idProduto;

	@Column(name = "fk_Id_Lote")
	private String lote;

	@Column(name = "fk_Id_ControleSaida")
	private Long idNotaFiscalSaida;

	@Column(name = "fk_Id_EtiquetaReferenciaSeparacao")
	private Long idEtiquetaReferenciaSeparacao;

	@Column(name = "fk_Id_Rua_Origem")
	private Long idRuaOrigem = (long) 0;

	@Column(name = "fk_Id_Rua_Dest")
	private Long idRuaDestino = (long) 0;

	@Column(name = "Ds_NumeroControladoIntegracao")
	private Integer dsNumeroControladoIntegracao = 0;

	public TarefaPosicionamento() {

	}

	public TarefaPosicionamento(Long idCliente, Long idStatusTarefa, Long idTipoTarefa, Long idUsuario,
			Long idEquipeCriador, Long idUsuarioMov, Long idEquipeExec, Long idTipoEquipe, LocalDateTime dataCriacao,
			LocalDateTime dataInicio, LocalDateTime dataFim, Float qtdProduto, Float qtdProdutoRestante,
			Integer nrSeqPrioridade, Integer nrSeqOrdemTarefa, Long nrSeqTarefaPai, Long idGalpaoOrigem,
			Long idBlocoOrigem, Long idPosicaoOrigem, Long idNivelOrigem, Long idGalpaoDestino, Long idBlocoDestino,
			Long idPosicaoDestino, Long idNivelDestino, Long idEtiqueta, Long idNotaFiscal, Long idProduto, String lote,
			Long idNotaFiscalSaida, Long idEtiquetaReferenciaSeparacao, Long idRuaOrigem, Long idRuaDestino,
			Integer dsNumeroControladoIntegracao) {

		this.idCliente = idCliente;
		this.idStatusTarefa = idStatusTarefa;
		this.idTipoTarefa = idTipoTarefa;
		this.idUsuario = idUsuario;
		this.idEquipeCriador = idEquipeCriador;
		this.idUsuarioMov = idUsuarioMov;
		this.idEquipeExec = idEquipeExec;
		this.idTipoEquipe = idTipoEquipe;
		this.dataCriacao = dataCriacao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.qtdProduto = qtdProduto;
		this.qtdProdutoRestante = qtdProdutoRestante;
		this.nrSeqPrioridade = nrSeqPrioridade;
		this.nrSeqOrdemTarefa = nrSeqOrdemTarefa;
		this.nrSeqTarefaPai = nrSeqTarefaPai;
		this.idGalpaoOrigem = idGalpaoOrigem;
		this.idBlocoOrigem = idBlocoOrigem;
		this.idPosicaoOrigem = idPosicaoOrigem;
		this.idNivelOrigem = idNivelOrigem;
		this.idGalpaoDestino = idGalpaoDestino;
		this.idBlocoDestino = idBlocoDestino;
		this.idPosicaoDestino = idPosicaoDestino;
		this.idNivelDestino = idNivelDestino;
		this.idEtiqueta = idEtiqueta;
		this.idNotaFiscal = idNotaFiscal;
		this.idProduto = idProduto;
		this.lote = lote;
		this.idNotaFiscalSaida = idNotaFiscalSaida;
		this.idEtiquetaReferenciaSeparacao = idEtiquetaReferenciaSeparacao;
		this.idRuaOrigem = idRuaOrigem;
		this.idRuaDestino = idRuaDestino;
		this.dsNumeroControladoIntegracao = dsNumeroControladoIntegracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdStatusTarefa() {
		return idStatusTarefa;
	}

	public void setIdStatusTarefa(Long idStatusTarefa) {
		this.idStatusTarefa = idStatusTarefa;
	}

	public Long getIdTipoTarefa() {
		return idTipoTarefa;
	}

	public void setIdTipoTarefa(Long idTipoTarefa) {
		this.idTipoTarefa = idTipoTarefa;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdEquipeCriador() {
		return idEquipeCriador;
	}

	public void setIdEquipeCriador(Long idEquipeCriador) {
		this.idEquipeCriador = idEquipeCriador;
	}

	public Long getIdUsuarioMov() {
		return idUsuarioMov;
	}

	public void setIdUsuarioMov(Long idUsuarioMov) {
		this.idUsuarioMov = idUsuarioMov;
	}

	public Long getIdEquipeExec() {
		return idEquipeExec;
	}

	public void setIdEquipeExec(Long idEquipeExec) {
		this.idEquipeExec = idEquipeExec;
	}

	public Long getIdTipoEquipe() {
		return idTipoEquipe;
	}

	public void setIdTipoEquipe(Long idTipoEquipe) {
		this.idTipoEquipe = idTipoEquipe;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public Float getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(Float qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public Float getQtdProdutoRestante() {
		return qtdProdutoRestante;
	}

	public void setQtdProdutoRestante(Float qtdProdutoRestante) {
		this.qtdProdutoRestante = qtdProdutoRestante;
	}

	public Integer getNrSeqPrioridade() {
		return nrSeqPrioridade;
	}

	public void setNrSeqPrioridade(Integer nrSeqPrioridade) {
		this.nrSeqPrioridade = nrSeqPrioridade;
	}

	public Integer getNrSeqOrdemTarefa() {
		return nrSeqOrdemTarefa;
	}

	public void setNrSeqOrdemTarefa(Integer nrSeqOrdemTarefa) {
		this.nrSeqOrdemTarefa = nrSeqOrdemTarefa;
	}

	public Long getNrSeqTarefaPai() {
		return nrSeqTarefaPai;
	}

	public void setNrSeqTarefaPai(Long nrSeqTarefaPai) {
		this.nrSeqTarefaPai = nrSeqTarefaPai;
	}

	public Long getIdGalpaoOrigem() {
		return idGalpaoOrigem;
	}

	public void setIdGalpaoOrigem(Long idGalpaoOrigem) {
		this.idGalpaoOrigem = idGalpaoOrigem;
	}

	public Long getIdBlocoOrigem() {
		return idBlocoOrigem;
	}

	public void setIdBlocoOrigem(Long idBlocoOrigem) {
		this.idBlocoOrigem = idBlocoOrigem;
	}

	public Long getIdPosicaoOrigem() {
		return idPosicaoOrigem;
	}

	public void setIdPosicaoOrigem(Long idPosicaoOrigem) {
		this.idPosicaoOrigem = idPosicaoOrigem;
	}

	public Long getIdNivelOrigem() {
		return idNivelOrigem;
	}

	public void setIdNivelOrigem(Long idNivelOrigem) {
		this.idNivelOrigem = idNivelOrigem;
	}

	public Long getIdGalpaoDestino() {
		return idGalpaoDestino;
	}

	public void setIdGalpaoDestino(Long idGalpaoDestino) {
		this.idGalpaoDestino = idGalpaoDestino;
	}

	public Long getIdBlocoDestino() {
		return idBlocoDestino;
	}

	public void setIdBlocoDestino(Long idBlocoDestino) {
		this.idBlocoDestino = idBlocoDestino;
	}

	public Long getIdPosicaoDestino() {
		return idPosicaoDestino;
	}

	public void setIdPosicaoDestino(Long idPosicaoDestino) {
		this.idPosicaoDestino = idPosicaoDestino;
	}

	public Long getIdNivelDestino() {
		return idNivelDestino;
	}

	public void setIdNivelDestino(Long idNivelDestino) {
		this.idNivelDestino = idNivelDestino;
	}

	public Long getIdEtiqueta() {
		return idEtiqueta;
	}

	public void setIdEtiqueta(Long idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
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

	public Long getIdNotaFiscalSaida() {
		return idNotaFiscalSaida;
	}

	public void setIdNotaFiscalSaida(Long idNotaFiscalSaida) {
		this.idNotaFiscalSaida = idNotaFiscalSaida;
	}

	public Long getIdEtiquetaReferenciaSeparacao() {
		return idEtiquetaReferenciaSeparacao;
	}

	public void setIdEtiquetaReferenciaSeparacao(Long idEtiquetaReferenciaSeparacao) {
		this.idEtiquetaReferenciaSeparacao = idEtiquetaReferenciaSeparacao;
	}

	public Long getIdRuaOrigem() {
		return idRuaOrigem;
	}

	public void setIdRuaOrigem(Long idRuaOrigem) {
		this.idRuaOrigem = idRuaOrigem;
	}

	public Long getIdRuaDestino() {
		return idRuaDestino;
	}

	public void setIdRuaDestino(Long idRuaDestino) {
		this.idRuaDestino = idRuaDestino;
	}

	public Integer getDsNumeroControladoIntegracao() {
		return dsNumeroControladoIntegracao;
	}

	public void setDsNumeroControladoIntegracao(Integer dsNumeroControladoIntegracao) {
		this.dsNumeroControladoIntegracao = dsNumeroControladoIntegracao;
	}

}
