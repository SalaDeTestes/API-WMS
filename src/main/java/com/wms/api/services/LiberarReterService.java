package com.wms.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wms.api.controller.dto.LiberarReterDto;
import com.wms.api.models.ControleEntradaProdutoPorPosicao;
import com.wms.api.models.NotaFiscalProduto;
import com.wms.api.repository.ControleEntradaProdutoPorPosicaoRepository;
import com.wms.api.repository.NotaFiscalProdutoRepository;

@Service
public class LiberarReterService {

	public Page<LiberarReterDto> liberarReterLista(NotaFiscalProdutoRepository notaFiscalProdutoRepository,
			Pageable pageable, ControleEntradaProdutoPorPosicaoRepository controleEntradaProdutoPorPosicaoRepository) {
		List<LiberarReterDto> resultList = new ArrayList<>();
		Page<NotaFiscalProduto> notaFiscalList = notaFiscalProdutoRepository.findAll(pageable);
		for (NotaFiscalProduto notaFiscal : notaFiscalList) {
			List<ControleEntradaProdutoPorPosicao> controleEntradaList = controleEntradaProdutoPorPosicaoRepository
					.findByLoteAndIdProdutoAndIdNotaFiscal(notaFiscal.getLote(), notaFiscal.getIdProduto(),
							notaFiscal.getIdNotaFiscal().getId());
			for (ControleEntradaProdutoPorPosicao controleEntrada : controleEntradaList) {
				LiberarReterDto result = new LiberarReterDto(notaFiscal, controleEntrada);
				result.setIdGalpao(controleEntrada.getIdGalpao());
				result.setIdBloco(controleEntrada.getIdBloco());
				result.setIdNivel(controleEntrada.getIdNivel());
				result.setIdPosicao(controleEntrada.getIdPosicao());
				result.setIdEtiqueta(controleEntrada.getIdEtiqueta());
				result.setLote(controleEntrada.getLote());
				result.setIdNotaFiscal(controleEntrada.getIdNotaFiscal());
				result.setIdProduto(controleEntrada.getIdProduto().getId());
				result.setEstoqueRetido(notaFiscal.getEstoqueRetido());
				result.setEstoqueLiberado(notaFiscal.getEstoqueLiberado());
				resultList.add(result);
			}
		}
		return new PageImpl<>(resultList, pageable, notaFiscalList.getTotalElements());
	}

	public void liberar(ControleEntradaProdutoPorPosicao porPosicao, NotaFiscalProduto nfProduto) {

		nfProduto.setEstoqueLiberado(nfProduto.getEstoqueRetido());
		nfProduto.setEstoqueRetido((float) 0);

	}

	public void reter(ControleEntradaProdutoPorPosicao porPosicao, NotaFiscalProduto nfProduto) {

		nfProduto.setEstoqueRetido(nfProduto.getEstoqueLiberado());
		nfProduto.setEstoqueLiberado((float) 0);

	}
}
