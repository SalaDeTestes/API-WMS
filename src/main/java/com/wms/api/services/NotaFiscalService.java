package com.wms.api.services;

import org.springframework.stereotype.Service;

import com.wms.api.form.NotaFiscalForm;
import com.wms.api.models.NotaFiscalProduto;
import com.wms.api.repository.NotaFiscalProdutoRepository;

@Service
public class NotaFiscalService {

	public void ItensDaNota(NotaFiscalForm form, NotaFiscalProdutoRepository nfprodutoRepository) {

		for (NotaFiscalProduto nfproduto : form.getProdutos()) {

			nfprodutoRepository.save(nfproduto);
		}
	}
}
