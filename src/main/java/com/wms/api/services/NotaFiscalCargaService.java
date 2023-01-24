package com.wms.api.services;

import org.springframework.stereotype.Service;

import com.wms.api.form.NotaFiscalIncluirCargaForm;
import com.wms.api.models.Doca;
import com.wms.api.models.NotaFiscal;
import com.wms.api.models.NotaFiscalCarga;
import com.wms.api.models.NotaFiscalCargaItens;
import com.wms.api.repository.DocaRepository;
import com.wms.api.repository.NotaFiscalCargaItensRepository;
import com.wms.api.repository.NotaFiscalRepository;

@Service
public class NotaFiscalCargaService {

	public void incluirCarga(NotaFiscalIncluirCargaForm form, NotaFiscalRepository nfRepository,
			DocaRepository docaRepository, NotaFiscalCargaItensRepository cargaitensRepository,
			NotaFiscalCarga nfcarga) {

		NotaFiscalCargaItens cargaItens = new NotaFiscalCargaItens();
		cargaItens.setIdNotaFiscal(nfRepository.getReferenceById(form.getIdNotaFiscal()));
		cargaItens.setIdNotaFiscalCarga(nfcarga);
		cargaitensRepository.save(cargaItens);

		Doca doca = docaRepository.getReferenceById(form.getIdDoca());
		doca.setOcupada(true);
		doca.setRecebimento(true);
		doca.setNumeroCarga(Long.toString(nfcarga.getId()));

		NotaFiscal nf = nfRepository.getReferenceById(form.getIdNotaFiscal());
		nf.setNumeroCarga(Long.toString(nfcarga.getId()));
		nf.setIdDoca(doca);
	}
}
