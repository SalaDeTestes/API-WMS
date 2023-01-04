package com.wms.api.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.wms.api.models.Cliente;
import com.wms.api.models.Motorista;
import com.wms.api.models.NotaFiscal;
import com.wms.api.models.NotaFiscalProduto;
import com.wms.api.models.PlacaTransportadora;
import com.wms.api.models.StatusNF;
import com.wms.api.models.TipoCaminhao;
import com.wms.api.models.TipoNotaEntrada;
import com.wms.api.models.Transportadora;
import com.wms.api.models.Usuario;

public class NotaFiscalDto {

	private Long id;
	private Transportadora idTransportadora;
	private Usuario idUsuario;
	private StatusNF idStatusNF;
	private String numeroNota;
	private String numeroSerie;
	private LocalDate dataEmissao;
	private LocalDateTime dataLancamento;
	private String observacao;
	private String chaveNfe;
	private PlacaTransportadora idPlaca;
	private String numeroCarga;
	private LocalDateTime dataCancelamento;
	private Float pesoLiquido;
	private Float pesoBruto;
	private Cliente idCliente;
	private String descricaoPlaca;
	private TipoNotaEntrada idTipoEntrada;
	private Motorista idMotorista;
	private Boolean entradaValidada;
	private TipoCaminhao idTipoCaminhao;
	private List<NotaFiscalProduto> produtos = new ArrayList<>();

	public NotaFiscalDto(NotaFiscal nf) {
		this.id = nf.getId();
		this.idTransportadora = nf.getIdTransportadora();
		this.idUsuario = nf.getIdUsuario();
		this.numeroNota = nf.getNumeroNota();
		this.numeroSerie = nf.getNumeroSerie();
		this.dataEmissao = nf.getDataEmissao();
		this.dataLancamento = nf.getDataLancamento();
		this.observacao = nf.getObservacao();
		this.chaveNfe = nf.getChaveNfe();
		this.idPlaca = nf.getIdPlaca();
		this.numeroCarga = nf.getNumeroCarga();
		this.dataCancelamento = nf.getDataCancelamento();
		this.pesoBruto = nf.getPesoBruto();
		this.pesoLiquido = nf.getPesoLiquido();
		this.idCliente = nf.getIdCliente();
		this.descricaoPlaca = nf.getDescricaoPlaca();
		this.idStatusNF = nf.getIdStatusNF();
		this.idTipoEntrada = nf.getIdTipoEntrada();
		this.idMotorista = nf.getIdMotorista();
		this.entradaValidada = nf.getEntradaValidada();
		this.idTipoCaminhao = nf.getIdTipoCaminhao();
		this.produtos = nf.getNotaFiscalProduto();
	}

	public Long getId() {
		return id;
	}

	public Transportadora getIdTransportadora() {
		return idTransportadora;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public StatusNF getIdStatusNF() {
		return idStatusNF;
	}

	public String getNumeroNota() {
		return numeroNota;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public LocalDateTime getDataLancamento() {
		return dataLancamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public String getChaveNfe() {
		return chaveNfe;
	}

	public PlacaTransportadora getIdPlaca() {
		return idPlaca;
	}

	public String getNumeroCarga() {
		return numeroCarga;
	}

	public LocalDateTime getDataCancelamento() {
		return dataCancelamento;
	}

	public Float getPesoLiquido() {
		return pesoLiquido;
	}

	public Float getPesoBruto() {
		return pesoBruto;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public String getDescricaoPlaca() {
		return descricaoPlaca;
	}

	public TipoNotaEntrada getIdTipoEntrada() {
		return idTipoEntrada;
	}

	public Motorista getIdMotorista() {
		return idMotorista;
	}

	public Boolean getEntradaValidada() {
		return entradaValidada;
	}

	public TipoCaminhao getIdTipoCaminhao() {
		return idTipoCaminhao;
	}
	

	public List<NotaFiscalProduto> getProdutos() {
		return produtos;
	}

	public static List<NotaFiscalDto> converter(List<NotaFiscal> nf) {

		return nf.stream().map(NotaFiscalDto::new).collect(Collectors.toList());
	}

}
