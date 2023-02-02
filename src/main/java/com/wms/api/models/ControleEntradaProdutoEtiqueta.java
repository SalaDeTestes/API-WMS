package com.wms.api.models;

/*Essa Tabela sera preenchida pelo service ControleRecebimentoService, no ato de inserção dos itens vindo do coletor, que se 
 * encontra no controller TarefaRecebimentoController*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbControleEntradaMercadoriaEtiqueta")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ControleEntradaProdutoEtiqueta {

	@Id
	@Column(name = "pk_Id_Etiqueta")
	private Long idEtiqueta;

	@Column(name = "fk_Id_ControleEntrada")
	private Long idNotaFiscal;

	@Column(name = "Ds_Etiqueta")
	private String descricaoEtiqueta;

	public ControleEntradaProdutoEtiqueta() {

	}

	public ControleEntradaProdutoEtiqueta(Long idEtiqueta, Long idNotaFiscal, String descricaoEtiqueta) {
		this.idEtiqueta = idEtiqueta;
		this.idNotaFiscal = idNotaFiscal;
		this.descricaoEtiqueta = descricaoEtiqueta;
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

	public String getDescricaoEtiqueta() {
		return descricaoEtiqueta;
	}

	public void setDescricaoEtiqueta(String descricaoEtiqueta) {
		this.descricaoEtiqueta = descricaoEtiqueta;
	}

}
