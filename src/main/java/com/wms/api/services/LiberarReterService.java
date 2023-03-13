package com.wms.api.services;

import org.springframework.stereotype.Service;

import com.wms.api.models.NotaFiscalProduto;

@Service
public class LiberarReterService {

	public void liberar(NotaFiscalProduto nfProduto) {

		if (nfProduto.getEstoqueRetido() != 0) {

			nfProduto.setEstoqueLiberado(nfProduto.getEstoqueRetido());
			nfProduto.setEstoqueRetido((float) 0);
		}

	}

	public void reter(NotaFiscalProduto nfProduto) {

		if (nfProduto.getEstoqueLiberado() != 0) {
			nfProduto.setEstoqueRetido(nfProduto.getEstoqueLiberado());
			nfProduto.setEstoqueLiberado((float) 0);
		}

	}
}
