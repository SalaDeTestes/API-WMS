package com.wms.api.services;

import org.springframework.stereotype.Service;


import com.wms.api.models.NotaFiscal;
import com.wms.api.models.NotaFiscalProduto;
import com.wms.api.repository.NotaFiscalProdutoRepository;


@Service
public class NotaFiscalService {

	public void ItensDaNota(NotaFiscal nf, NotaFiscalProdutoRepository nfprodutoRepository) {

		for (NotaFiscalProduto nfproduto : nf.getNotaFiscalProduto()) {
			nfproduto.setIdNotaFiscal(nf);
			nfprodutoRepository.save(nfproduto);
		}
	}
}
