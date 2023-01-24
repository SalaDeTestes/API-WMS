package com.wms.api.models;

/*Essa Tabela sera preenchida pelo service ControleRecebimentoService, no ato de inserção dos itens vindo do coletor, que se 
 * encontra no controller TarefaRecebimentoController*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbControleEntradaColetorStatus")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ControleEntradaColetorStatus {

	@Id
	@Column(name = "fk_Id_Identificador")
	private Long idControleColetor;

	@Column(name = "fk_Id_Revisao")
	private Long revisao = (long) 1;

	@Column(name = "fk_Id_ControleEntrada")
	private Long idNotaFiscal;

	@Column(name = "fg_Status")
	private Boolean situacao = true;

	public ControleEntradaColetorStatus() {

	}

	public ControleEntradaColetorStatus(Long idControleColetor, Long revisao, Long idNotaFiscal, Boolean situacao) {

		this.idControleColetor = idControleColetor;
		this.revisao = revisao;
		this.idNotaFiscal = idNotaFiscal;
		this.situacao = situacao;
	}

	public Long getIdControleColetor() {
		return idControleColetor;
	}

	public void setIdControleColetor(Long idControleColetor) {
		this.idControleColetor = idControleColetor;
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

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

}
