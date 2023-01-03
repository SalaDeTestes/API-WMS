package com.wms.api.form;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.wms.api.models.NotaFiscal;
import com.wms.api.repository.ClienteRepository;
import com.wms.api.repository.MotoristaRepository;
import com.wms.api.repository.NotaFiscalRepository;
import com.wms.api.repository.PlacaTransportadoraRepository;
import com.wms.api.repository.StatusNFRepository;
import com.wms.api.repository.TipoCaminhaoRepository;
import com.wms.api.repository.TipoNotaEntradaRepository;
import com.wms.api.repository.TransportadoraRepository;
import com.wms.api.repository.UsuarioRepository;

public class NotaFiscalForm {

	private Integer idTransportadora;
	private Long idUsuario;
	private Long idStatusNF;
	private String numeroNota;
	private String numeroSerie;
	private LocalDate dataEmissao;
	private LocalDateTime dataLancamento;
	private String observacao;
	private String chaveNfe;
	private Long idCliente;
	private Long idPlaca;
	private Float pesoLiquido;
	private Float pesoBruto;
	private LocalDateTime dataCancelamento;
	private String numeroCarga;
	private String descricaoPlaca;
	private Long idTipoEntrada;
	private Long idMotorista;
	private Boolean entradaValidada;
	private Long idTipoCaminhao;

	public Integer getIdTransportadora() {
		return idTransportadora;
	}

	public void setIdTransportadora(Integer idTransportadora) {
		this.idTransportadora = idTransportadora;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdStatusNF() {
		return idStatusNF;
	}

	public void setIdStatusNF(Long idStatusNF) {
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

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
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

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdPlaca() {
		return idPlaca;
	}

	public void setIdPlaca(Long idPlaca) {
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

	public Long getIdTipoEntrada() {
		return idTipoEntrada;
	}

	public void setIdTipoEntrada(Long idTipoEntrada) {
		this.idTipoEntrada = idTipoEntrada;
	}

	public Long getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(Long idMotorista) {
		this.idMotorista = idMotorista;
	}

	public Boolean getEntradaValidada() {
		return entradaValidada;
	}

	public void setEntradaValidada(Boolean entradaValidada) {
		this.entradaValidada = entradaValidada;
	}

	public Long getIdTipoCaminhao() {
		return idTipoCaminhao;
	}

	public void setIdTipoCaminhao(Long idTipoCaminhao) {
		this.idTipoCaminhao = idTipoCaminhao;
	}

	public NotaFiscal formulario(TransportadoraRepository transportadoraRepository, UsuarioRepository usuarioRepository,
			StatusNFRepository statusRepository, ClienteRepository clienteRepository,
			PlacaTransportadoraRepository placaRepository, MotoristaRepository motoristaRepository,
			TipoNotaEntradaRepository tipoRepository, TipoCaminhaoRepository caminhaoRepository) {

		NotaFiscal nf = new NotaFiscal();

		nf.setIdTransportadora(transportadoraRepository.getReferenceById(idTransportadora));
		nf.setIdUsuario(usuarioRepository.getReferenceById(idUsuario));
		nf.setIdStatusNF(statusRepository.getReferenceById(idStatusNF));
		nf.setIdCliente(clienteRepository.getReferenceById(idCliente));
		nf.setNumeroNota(numeroNota);
		nf.setNumeroSerie(numeroSerie);
		nf.setDataEmissao(dataEmissao);
		nf.setObservacao(observacao);
		nf.setChaveNfe(chaveNfe);
		nf.setNumeroCarga(numeroCarga);
		nf.setPesoBruto(pesoBruto);
		nf.setPesoLiquido(pesoLiquido);
		nf.setIdPlaca(placaRepository.getReferenceById(idPlaca));
		nf.setDescricaoPlaca(placaRepository.getReferenceById(idPlaca).getDescricao());
		nf.setIdMotorista(motoristaRepository.getReferenceById(idMotorista));
		nf.setIdTipoEntrada(tipoRepository.getReferenceById(idTipoEntrada));
		nf.setEntradaValidada(false);
		nf.setIdTipoCaminhao(caminhaoRepository.getReferenceById(idTipoCaminhao));

		return nf;
	}

	public NotaFiscal atualizar(Long id, TransportadoraRepository transportadoraRepository,
			UsuarioRepository usuarioRepository, StatusNFRepository statusRepository, NotaFiscalRepository nfRepository,
			ClienteRepository clienteRepository, PlacaTransportadoraRepository placaRepository,
			MotoristaRepository motoristaRepository, TipoNotaEntradaRepository tipoRepository,
			TipoCaminhaoRepository caminhaoRepository) {

		NotaFiscal nf = nfRepository.getReferenceById(id);

		nf.setIdTransportadora(transportadoraRepository.getReferenceById(idTransportadora));
		nf.setIdUsuario(usuarioRepository.getReferenceById(idUsuario));
		nf.setIdStatusNF(statusRepository.getReferenceById(idStatusNF));
		nf.setIdCliente(clienteRepository.getReferenceById(idCliente));
		nf.setNumeroNota(numeroNota);
		nf.setNumeroSerie(numeroSerie);
		nf.setDataEmissao(dataEmissao);
		nf.setObservacao(observacao);
		nf.setChaveNfe(chaveNfe);
		nf.setDataCancelamento(dataCancelamento);
		nf.setNumeroCarga(numeroCarga);
		nf.setPesoBruto(pesoBruto);
		nf.setPesoLiquido(pesoLiquido);
		nf.setIdPlaca(placaRepository.getReferenceById(idPlaca));
		nf.setDescricaoPlaca(placaRepository.getReferenceById(idPlaca).getDescricao());
		nf.setIdMotorista(motoristaRepository.getReferenceById(idMotorista));
		nf.setIdTipoEntrada(tipoRepository.getReferenceById(idTipoEntrada));
		nf.setEntradaValidada(false);
		nf.setIdTipoCaminhao(caminhaoRepository.getReferenceById(idTipoCaminhao));

		return nf;
	}

}
