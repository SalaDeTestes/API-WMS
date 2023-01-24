package com.wms.api.models;

/*Essa tabela é usada como modelo de dados para entrada dos dados do Coletor no controller TarefaRecebimentoController, 
 * atraves desses dados as demais tabelas do recebimento são preenchidas*/
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbControleRecebimento")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ControleRecebimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Recebimento")
	private Long id;

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

	@Column(name = "Dt_Hora_fim")
	private LocalDateTime dataFim;

	@OneToMany(mappedBy = "numeroCarga")
	private List<ControleEntradaColetor> controleEntradaColetor = new ArrayList<>();

	public ControleRecebimento() {

	}

	public ControleRecebimento(Long idUsuario, Long idEquipamento, String numeroCarga, Long idDoca,
			LocalDateTime dataInicio, LocalDateTime dataFim, List<ControleEntradaColetor> controleEntradaColetor) {

		this.idUsuario = idUsuario;
		this.idEquipamento = idEquipamento;
		this.numeroCarga = numeroCarga;
		this.idDoca = idDoca;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.controleEntradaColetor = controleEntradaColetor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<ControleEntradaColetor> getControleEntradaColetor() {
		return controleEntradaColetor;
	}

	public void setControleEntradaColetor(List<ControleEntradaColetor> controleEntradaColetor) {
		this.controleEntradaColetor = controleEntradaColetor;
	}

}
