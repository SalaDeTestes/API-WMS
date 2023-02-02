package com.wms.api.form;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wms.api.models.ControleEntradaColetor;
import com.wms.api.models.ControleEntradaProdutoConferencia;
import com.wms.api.models.ControleRecebimento;

public class ControleRecebimentoForm {

	private Long idUsuario;
	private Long idEquipamento;
	private String numeroCarga;
	private Long idDoca;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	private List<ControleEntradaColetor> controleEntradaColetor = new ArrayList<>();
	private List<ControleEntradaProdutoConferencia> controleEntradaProdutoConferencia = new ArrayList<>();

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(Long idEquipamento) {
		this.idEquipamento = idEquipamento;
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

	public List<ControleEntradaColetor> getControleEntradaColetor() {
		return controleEntradaColetor;
	}

	public void setControleEntradaColetor(List<ControleEntradaColetor> controleEntradaColetor) {
		this.controleEntradaColetor = controleEntradaColetor;
	}

	public List<ControleEntradaProdutoConferencia> getControleEntradaProdutoConferencia() {
		return controleEntradaProdutoConferencia;
	}

	public void setControleEntradaProdutoConferencia(
			List<ControleEntradaProdutoConferencia> controleEntradaProdutoConferencia) {
		this.controleEntradaProdutoConferencia = controleEntradaProdutoConferencia;
	}

	public ControleRecebimento formulario() {
		ControleRecebimento controleRecebimento = new ControleRecebimento();

		controleRecebimento.setIdUsuario(idUsuario);
		controleRecebimento.setIdEquipamento(idEquipamento);
		controleRecebimento.setNumeroCarga(numeroCarga);
		controleRecebimento.setIdDoca(idDoca);
		controleRecebimento.setDataInicio(dataInicio);
		controleRecebimento.setDataFim(dataFim);
		controleRecebimento.setControleEntradaColetor(controleEntradaColetor);
		controleRecebimento.setControleEntradaProdutoConferencia(controleEntradaProdutoConferencia);

		return controleRecebimento;
	}

}
