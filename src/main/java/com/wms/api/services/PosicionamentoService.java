package com.wms.api.services;

import java.util.Optional;

import com.wms.api.models.ControleEntradaColetor;
import com.wms.api.models.ControleEntradaProdutoPorPosicao;
import com.wms.api.models.GalpaoLayout;
import com.wms.api.repository.ControleEntradaColetorRepository;
import com.wms.api.repository.ControleEntradaProdutoPorPosicaoRepository;
import com.wms.api.repository.GalpaoLayoutRepository;

public class PosicionamentoService {



	// Se o retorno for true significa que a posição ja esta sendo ocupada, false
	// posição vazia
	public boolean validaPosicao(ControleEntradaProdutoPorPosicaoRepository prodPosicaoRepository,
			ControleEntradaProdutoPorPosicao prodPosicao) {
		Optional<ControleEntradaProdutoPorPosicao> prodPosicaoValida = prodPosicaoRepository
				.findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(prodPosicao.getIdGalpao(), prodPosicao.getIdBloco(),
						prodPosicao.getIdPosicao(), prodPosicao.getIdNivel());

		if (prodPosicaoValida.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	// Se retorno for true significa que a posição existe, false posição não existe
	public static boolean validaExistePosicao(GalpaoLayoutRepository galpaoLayoutRepository,
			String etiquetaPosicionamento) {
		// Substring Etiqueta
		// 000 galpao 000 bloco 00 nivel 00 posição
		etiquetaPosicionamento = "0010040101";

		Long idGalpao = Long.parseLong(etiquetaPosicionamento.substring(1, 3));
		Long idBloco = Long.parseLong(etiquetaPosicionamento.substring(3, 6));
		Long idPosicao = Long.parseLong(etiquetaPosicionamento.substring(6, 8));
		Long idNivel = Long.parseLong(etiquetaPosicionamento.substring(8, 10));

		System.out.println("idGalpao " + idGalpao);
		System.out.println("idBloco " + idBloco);
		System.out.println("idPosição " + idPosicao);
		System.out.println("idNivel " + idNivel);

		//OBS:O CAMPO ID DA TABELA NAO PODE FICAR VAZIO SENÃO ELE NÃO ACHA O REGISTRO!!!
		
		Optional<GalpaoLayout> galpaoLayoutValidado = galpaoLayoutRepository
				.findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(idGalpao, idBloco, idPosicao, idNivel);
		if (galpaoLayoutValidado.isPresent()) {
			System.out.println("existe");
			return true;
		}
		System.out.println("Não existe");

		return false;
	}

	public void posicionaProduto(ControleEntradaProdutoPorPosicaoRepository prodPosicaoRepository,
			String EtiquetaProduto, ControleEntradaColetorRepository controleEntradaColetorRepository,
			String etiquetaPosicionamento) {


		Long idGalpao = Long.parseLong(etiquetaPosicionamento.substring(1, 3));
		Long idBloco = Long.parseLong(etiquetaPosicionamento.substring(3, 6));
		Long idPosicao = Long.parseLong(etiquetaPosicionamento.substring(6, 8));
		Long idNivel = Long.parseLong(etiquetaPosicionamento.substring(8, 10));

		ControleEntradaColetor controleEntradaColetor = controleEntradaColetorRepository
				.findByIdEtiqueta(Long.parseLong(EtiquetaProduto));

		// findByIdNotaFiscalAndIdProdutoAndLoteAndIdEtiqueta();
		ControleEntradaProdutoPorPosicao prodPosicao = new ControleEntradaProdutoPorPosicao();
		prodPosicao.setIdProduto(controleEntradaColetor.getIdProduto());
		prodPosicao.setIdEtiqueta(controleEntradaColetor.getIdEtiqueta());
		prodPosicao.setIdNotaFiscal(controleEntradaColetor.getIdNotaFiscal());
		prodPosicao.setQuantidade(controleEntradaColetor.getQuantidade());
		prodPosicao.setIdStatusMovimentacao((long) 2);
		prodPosicao.setQuatidadePallets(controleEntradaColetor.getNumeroPallet());
		prodPosicao.setIdUsuario(controleEntradaColetor.getIdUsuario());
		prodPosicao.setLote(controleEntradaColetor.getLote());
		prodPosicao.setIdRua((long) 0);
		prodPosicao.setNumeroSaidasEmAberto(0);
		prodPosicao.setIdBloco(idBloco);
		prodPosicao.setIdNivel(idNivel);
		prodPosicao.setIdGalpao(idGalpao);
		prodPosicao.setIdPosicao(idPosicao);

		prodPosicaoRepository.save(prodPosicao);

	}
}
