package com.wms.api.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wms.api.models.ControleEntradaColetor;
import com.wms.api.models.ControleRecebimento;

public class ControleRecebimentoDto {

	private Long id;
	private Long idUsuario;
	private Long idEquipamento;
	private String numeroCarga;
	private Long idDoca;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	private List<ControleEntradaColetor> controleEntradaColetor = new ArrayList<>();

	public ControleRecebimentoDto(ControleRecebimento controleRecebimento) {
		this.id = controleRecebimento.getId();
		this.idUsuario = controleRecebimento.getIdUsuario();
		this.idEquipamento = controleRecebimento.getIdEquipamento();
		this.numeroCarga = controleRecebimento.getNumeroCarga();
		this.idDoca = controleRecebimento.getIdDoca();
		this.dataInicio = controleRecebimento.getDataInicio();
		this.dataFim = controleRecebimento.getDataFim();
		this.controleEntradaColetor = controleRecebimento.getControleEntradaColetor();
	}

	public Long getId() {
		return id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public Long getIdEquipamento() {
		return idEquipamento;
	}

	public String getNumeroCarga() {
		return numeroCarga;
	}

	public Long getIdDoca() {
		return idDoca;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public List<ControleEntradaColetor> getControleEntradaColetor() {
		return controleEntradaColetor;
	}

}
