package com.wms.api.form;

import com.wms.api.models.Doca;
import com.wms.api.repository.DocaRepository;

public class DocaForm {

	private Long idGalpao;
	private String descricao;
	private Boolean ocupada;
	private String numeroCarga;
	private Boolean recebimento;

	public Long getIdGalpao() {
		return idGalpao;
	}

	public void setIdGalpao(Long idGalpao) {
		this.idGalpao = idGalpao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getOcupada() {
		return ocupada;
	}

	public void setOcupada(Boolean ocupada) {
		this.ocupada = ocupada;
	}

	public String getNumeroCarga() {
		return numeroCarga;
	}

	public void setNumeroCarga(String numeroCarga) {
		this.numeroCarga = numeroCarga;
	}

	public Boolean getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(Boolean recebimento) {
		this.recebimento = recebimento;
	}

	public Doca formulario() {
		Doca doca = new Doca();
		doca.setDescricao(descricao);
		doca.setIdGalpao(idGalpao);
		doca.setOcupada(ocupada);
		doca.setNumeroCarga(numeroCarga);
		doca.setRecebimento(recebimento);
		return doca;
	}

	public Doca atualizar(Long id, DocaRepository docaRepository) {
		Doca doca = docaRepository.getReferenceById(id);
		doca.setDescricao(descricao);
		doca.setIdGalpao(idGalpao);
		doca.setOcupada(ocupada);
		doca.setNumeroCarga(numeroCarga);
		doca.setRecebimento(recebimento);
		return doca;
	}

}
