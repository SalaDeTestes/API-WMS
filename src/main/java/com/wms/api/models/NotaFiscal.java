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
@Table(name = "\"tbControleEntrada\"")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class NotaFiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_ControleEntrada")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_Id_Transportadora")
	private Transportadora idTransportadora;
	
	@ManyToOne
	@JoinColumn(name = "fk_Id_Motorista")
	private Motorista idMotorista;
	
	@ManyToOne
	@JoinColumn(name = "fk_Id_TipoNF")
	private TipoNotaEntrada idTipoEntrada;
	
	@Column(name = "fg_EntValidada")
	private Boolean entradaValidada;

	@ManyToOne
	@JoinColumn(name = "fk_id_PlacaTransporte")
	private PlacaTransportadora idPlaca;

	@ManyToOne
	@JoinColumn(name = "fk_Id_Usuario")
	private Usuario idUsuario;

	@ManyToOne
	@JoinColumn(name = "fk_Id_Cliente")
	private Cliente idCliente;

	@ManyToOne
	@JoinColumn(name = "fk_Id_StatusNF")
	private StatusNF idStatusNF;

	@Column(name = "Nr_Documento")
	private String numeroNota;

	@Column(name = "Nr_Serie")
	private String numeroSerie;

	@Column(name = "Dt_EmissaoDocumento")
	private LocalDateTime dataEmissao;

	@Column(name = "Dt_Lancamento")
	private LocalDateTime dataLancamento;

	@Column(name = "Ds_Observacao")
	private String observacao;

	@Column(name = "Nr_Numeracao")
	private String chaveNfe;

	@Column(name = "Nr_PesoLiquido")
	private Float pesoLiquido;

	@Column(name = "Nr_PesoBruto")
	private Float pesoBruto;

	@Column(name = "dt_Cancelamento")
	private LocalDateTime dataCancelamento;

	@Column(name = "Nr_Carga")
	private String numeroCarga;
	
	@Column(name = "Ds_PlacaTransporte")
	private String descricaoPlaca;

	public NotaFiscal() {

	}

	public NotaFiscal(Transportadora idTransportadora, Usuario idUsuario, StatusNF idStatusNF, String numeroNota,
			String numeroSerie, LocalDateTime dataEmissao, LocalDateTime dataLancamento, String observacao,
			String chaveNfe, Cliente idCliente, PlacaTransportadora idPlaca, Float pesoLiquido, Float pesoBruto,
			LocalDateTime dataCancelamento, String numeroCarga, String descricaoPlaca, TipoNotaEntrada idTipoEntrada, Motorista idMotorista, Boolean entradaValidada) {
		this.idTransportadora = idTransportadora;
		this.idUsuario = idUsuario;
		this.idStatusNF = idStatusNF;
		this.numeroNota = numeroNota;
		this.numeroSerie = numeroSerie;
		this.dataEmissao = dataEmissao;
		this.dataLancamento = dataLancamento;
		this.observacao = observacao;
		this.chaveNfe = chaveNfe;
		this.idCliente = idCliente;
		this.idPlaca = idPlaca;
		this.pesoLiquido = pesoLiquido;
		this.pesoBruto = pesoBruto;
		this.dataCancelamento = dataCancelamento;
		this.numeroCarga = numeroCarga;
		this.descricaoPlaca = descricaoPlaca;
		this.idTipoEntrada = idTipoEntrada;
		this.idMotorista = idMotorista;
		this.entradaValidada = entradaValidada;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Transportadora getIdTransportadora() {
		return idTransportadora;
	}

	public void setIdTransportadora(Transportadora idTransportadora) {
		this.idTransportadora = idTransportadora;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public StatusNF getIdStatusNF() {
		return idStatusNF;
	}

	public void setIdStatusNF(StatusNF idStatusNF) {
		this.idStatusNF = idStatusNF;
	}

	public String getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public LocalDateTime getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDateTime dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public LocalDateTime getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDateTime dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getChaveNfe() {
		return chaveNfe;
	}

	public void setChaveNfe(String chaveNfe) {
		this.chaveNfe = chaveNfe;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public PlacaTransportadora getIdPlaca() {
		return idPlaca;
	}

	public void setIdPlaca(PlacaTransportadora idPlaca) {
		this.idPlaca = idPlaca;
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

	public LocalDateTime getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(LocalDateTime dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public String getNumeroCarga() {
		return numeroCarga;
	}

	public void setNumeroCarga(String numeroCarga) {
		this.numeroCarga = numeroCarga;
	}

	public String getDescricaoPlaca() {
		return descricaoPlaca;
	}

	public void setDescricaoPlaca(String descricaoPlaca) {
		this.descricaoPlaca = descricaoPlaca;
	}

	public Motorista getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(Motorista idMotorista) {
		this.idMotorista = idMotorista;
	}

	public TipoNotaEntrada getIdTipoEntrada() {
		return idTipoEntrada;
	}

	public void setIdTipoEntrada(TipoNotaEntrada idTipoEntrada) {
		this.idTipoEntrada = idTipoEntrada;
	}

	public Boolean getEntradaValidada() {
		return entradaValidada;
	}

	public void setEntradaValidada(Boolean entradaValidada) {
		this.entradaValidada = entradaValidada;
	}
	
	

}
