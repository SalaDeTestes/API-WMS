package com.wms.api.models;

/*Essa Tabela sera preenchida pelo service ControleRecebimentoService, no ato de inserção dos itens vindo do coletor, que se 
 * encontra no controller TarefaRecebimentoController*/
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbControleConferencia")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ControleConferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Conferencia")
	private Long id;

	@Column(name = "pk_Id_Revisao")
	private Long revisao;

	@Column(name = "fk_Id_Usuario")
	private Long idUsuario;

	@Column(name = "fk_Id_Equipamento")
	private Long idEquipamento;

	@Column(name = "Nr_Carga")
	private String numeroCarga;

	@Column(name = "Nr_Doca")
	private Long idDoca;

	@Column(name = "Dt_Hora_Ini")
	private LocalDateTime dataInicio;

	@Column(name = "Dt_Hora_Fim")
	private LocalDateTime dataFim = LocalDateTime.now();

	public ControleConferencia() {

	}

	public ControleConferencia(Long revisao, Long idUsuario, Long idEquipamento, String numeroCarga, Long idDoca,
			LocalDateTime dataInicio, LocalDateTime dataFim) {

		this.revisao = revisao;
		this.idUsuario = idUsuario;
		this.idEquipamento = idEquipamento;
		this.numeroCarga = numeroCarga;
		this.idDoca = idDoca;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
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

}
