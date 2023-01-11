package com.wms.api.form;

import com.wms.api.models.NotaFiscal;
import com.wms.api.models.NotaFiscalCarga;
import com.wms.api.repository.DocaRepository;
import com.wms.api.repository.NotaFiscalRepository;

public class NotaFiscalIncluirCargaForm {

	private Long idNotaFiscal;
	private Long idDoca;

	public Long getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(Long idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

	public Long getIdDoca() {
		return idDoca;
	}

	public void setIdDoca(Long idDoca) {
		this.idDoca = idDoca;
	}

	public NotaFiscal formularioNf(NotaFiscalRepository nfRepository) {
		NotaFiscal nf = nfRepository.getReferenceById(idNotaFiscal);
		return nf;
	}

	public NotaFiscalCarga formularioNfCarga(DocaRepository docaRepository) {

		NotaFiscalCarga nfcarga = new NotaFiscalCarga();

		nfcarga.setIdDoca(docaRepository.getReferenceById(idDoca));

		return nfcarga;
	}

}
