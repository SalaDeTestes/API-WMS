package com.wms.api.form;

import com.wms.api.models.StatusNF;
import com.wms.api.repository.StatusNFRepository;

public class StatusNFForm {

	private String descricaoStatus;

	public String getDescricaoStatus() {
		return descricaoStatus;
	}

	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}
	
	public StatusNF formulario() {
		StatusNF status = new StatusNF();
		
		status.setDescricaoStatus(descricaoStatus);
		
		return status;
	}
	
	public StatusNF atualizar(Long id, StatusNFRepository statusRepository) {
		StatusNF status = statusRepository.getReferenceById(id);
		
		status.setDescricaoStatus(descricaoStatus);
		
		return status;
	}
}
