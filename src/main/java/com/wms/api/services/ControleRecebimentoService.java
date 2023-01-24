package com.wms.api.services;

import com.wms.api.models.ControleEntradaColetor;
import com.wms.api.models.ControleEntradaEtiqueta;
import com.wms.api.models.ControleEntradaProdutoConferencia;
import com.wms.api.models.ControleEntradaProdutoPorPosicao;
import com.wms.api.models.ControleRecebimento;
import com.wms.api.repository.ControleEntradaColetorRepository;
import com.wms.api.repository.ControleEntradaEtiquetaRepository;
import com.wms.api.repository.ControleEntradaProdutoConferenciaRepository;
import com.wms.api.repository.ControleEntradaProdutoPorPosicaoRepository;
import com.wms.api.repository.ControleRecebimentoRepository;
import com.wms.api.repository.ProdutoRepository;

public class ControleRecebimentoService {
	public void salvarRecebimento(ControleRecebimento controleRecebimento,
			ControleRecebimentoRepository controleRecebimentoRepository,
			ControleEntradaColetorRepository entradaColetorRepository, ProdutoRepository produtoRepository,
			ControleEntradaProdutoPorPosicaoRepository controleEntradaProdutoPorPosicaoRepository,
			ControleEntradaEtiquetaRepository controleEntradaEtiquetaRepository,
			ControleEntradaProdutoConferenciaRepository controleEntradaProdutoConferenciaRepository) {

		for (ControleEntradaColetor controleEntradaColetor : controleRecebimento.getControleEntradaColetor()) {

			ControleEntradaProdutoPorPosicao controleEntradaProdutoPorPosicao = new ControleEntradaProdutoPorPosicao();
			controleEntradaProdutoPorPosicao.setIdNotaFiscal(controleEntradaColetor.getIdNotaFiscal());
			controleEntradaProdutoPorPosicao.setIdProduto(controleEntradaColetor.getIdProduto());
			controleEntradaProdutoPorPosicao.setLote(controleEntradaColetor.getLote());
			controleEntradaProdutoPorPosicao.setIdGalpao(produtoRepository
					.findById(controleEntradaColetor.getIdProduto()).get().getIdCategoriaGalpao().getId());
			controleEntradaProdutoPorPosicao.setQuantidade(controleEntradaColetor.getQuantidade());
			controleEntradaProdutoPorPosicao.setQuatidadePallets(controleEntradaColetor.getNumeroPallet());
			controleEntradaProdutoPorPosicao.setIdEtiqueta(controleEntradaColetor.getIdEtiqueta());
			controleEntradaProdutoPorPosicao.setIdStatusMovimentacao((long) 3);
			controleEntradaProdutoPorPosicao.setIdUsuario(controleRecebimento.getIdUsuario());

			controleEntradaProdutoPorPosicaoRepository.save(controleEntradaProdutoPorPosicao);

			ControleEntradaEtiqueta controleEntradaEtiqueta = new ControleEntradaEtiqueta();
			controleEntradaEtiqueta.setIdNotaFiscal(controleEntradaColetor.getIdNotaFiscal());
			controleEntradaEtiqueta.setIdEtiqueta(controleEntradaColetor.getIdEtiqueta());

			controleEntradaEtiquetaRepository.save(controleEntradaEtiqueta);

			ControleEntradaProdutoConferencia controleEntradaProdutoConferencia = new ControleEntradaProdutoConferencia();
			controleEntradaProdutoConferencia.setIdNotaFiscal(controleEntradaColetor.getIdNotaFiscal());
			controleEntradaProdutoConferencia.setIdProduto(controleEntradaColetor.getIdProduto());
			controleEntradaProdutoConferencia.setLote(controleEntradaColetor.getLote());
			controleEntradaProdutoConferencia.setIdUsuario(controleRecebimento.getIdUsuario());
			controleEntradaProdutoConferencia.setQuantidadeProduto(controleEntradaColetor.getQuantidade());
			controleEntradaProdutoConferencia.setQuantidadePallet(controleEntradaColetor.getNumeroPallet());
			controleEntradaProdutoConferencia.setQuantidadeProdutoConferida(controleEntradaColetor.getQuantidade());
			controleEntradaProdutoConferencia.setQuantidadePalletConferida(controleEntradaColetor.getNumeroPallet());
			controleEntradaProdutoConferencia.setIdLiberadoRetido('L');

			controleEntradaProdutoConferenciaRepository.save(controleEntradaProdutoConferencia);

			entradaColetorRepository.save(controleEntradaColetor);

		}
	}

}
