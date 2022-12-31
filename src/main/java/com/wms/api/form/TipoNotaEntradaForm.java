package com.wms.api.form;

import com.wms.api.models.TipoNotaEntrada;
import com.wms.api.repository.TipoNotaEntradaRepository;

public class TipoNotaEntradaForm {

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public TipoNotaEntrada formulario() {
		
		TipoNotaEntrada tipo = new TipoNotaEntrada();
		
		tipo.setDescricao(descricao);
		
		return tipo;
	}
	
public TipoNotaEntrada atualizar(Long id, TipoNotaEntradaRepository tipoRepository) {
		
		TipoNotaEntrada tipo = tipoRepository.getReferenceById(id);
		
		tipo.setDescricao(descricao);
		
		return tipo;
	}
}
