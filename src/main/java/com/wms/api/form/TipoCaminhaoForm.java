package com.wms.api.form;

import com.wms.api.models.TipoCaminhao;
import com.wms.api.repository.TipoCaminhaoRepository;

public class TipoCaminhaoForm {

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public TipoCaminhao formulario() {
		TipoCaminhao caminhao = new TipoCaminhao();
		
		caminhao.setDescricao(descricao);
		
		return caminhao;
	}
	
	public TipoCaminhao atualizar(Long id, TipoCaminhaoRepository caminhaoRepository) {
		TipoCaminhao caminhao = caminhaoRepository.getReferenceById(id);
		
		caminhao.setDescricao(descricao);
		
		return caminhao;
	}
}
