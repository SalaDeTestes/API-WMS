package com.wms.api.models;

/*Essa Tabela sera preenchida pelo service ControleRecebimentoService, no ato de inserção dos itens vindo do coletor, que se 
 * encontra no controller TarefaRecebimentoController*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbControleEntradaMercadoriaEtiqueta")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ControleEntradaProdutoEtiqueta {

	@Id
	@Column(name = "pk_Id_Etiqueta")
	private Long idEtiqueta;

	@ManyToOne
	@JoinColumn(name = "fk_Id_ControleEntrada")
	private NotaFiscal idNotaFiscal;

	@Column(name = "Ds_Etiqueta")
	private String descicaoEtiqueta;

	public ControleEntradaProdutoEtiqueta() {

	}

	public ControleEntradaProdutoEtiqueta(Long idEtiqueta, NotaFiscal idNotaFiscal, String descicaoEtiqueta) {
		this.idEtiqueta = idEtiqueta;
		this.idNotaFiscal = idNotaFiscal;
		this.descicaoEtiqueta = descicaoEtiqueta;
	}

	public Long getIdEtiqueta() {
		return idEtiqueta;
	}

	public void setIdEtiqueta(Long idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public NotaFiscal getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(NotaFiscal idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

	public String getDescicaoEtiqueta() {
		return descicaoEtiqueta;
	}

	public void setDescicaoEtiqueta(String descicaoEtiqueta) {
		this.descicaoEtiqueta = descicaoEtiqueta;
	}

}
