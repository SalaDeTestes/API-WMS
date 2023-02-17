package com.wms.api.services;

import java.util.List;
import java.util.Optional;

import com.wms.api.models.ControleEntradaColetor;
import com.wms.api.models.ControleEntradaProdutoEtiqueta;
import com.wms.api.models.ControleEntradaProdutoPorPosicao;
import com.wms.api.models.GalpaoLayout;
import com.wms.api.repository.ControleEntradaColetorRepository;
import com.wms.api.repository.ControleEntradaProdutoEtiquetaRepository;
import com.wms.api.repository.ControleEntradaProdutoPorPosicaoRepository;
import com.wms.api.repository.GalpaoLayoutRepository;

public class PosicionamentoService {

	// False = ocupada/não existe/erro
	// true = vazia/livre
	public static boolean validaPosicao(ControleEntradaProdutoPorPosicaoRepository prodPosicaoRepository,
			GalpaoLayoutRepository galpaoLayoutRepository, String etiquetaPosicionamento) {

		Long idGalpao = Long.parseLong(etiquetaPosicionamento.substring(1, 3));
		Long idBloco = Long.parseLong(etiquetaPosicionamento.substring(3, 6));
		Long idPosicao = Long.parseLong(etiquetaPosicionamento.substring(6, 8));
		Long idNivel = Long.parseLong(etiquetaPosicionamento.substring(8, 10));

		System.out.println("idGalpao " + idGalpao);
		System.out.println("idBloco " + idBloco);
		System.out.println("idPosição " + idPosicao);
		System.out.println("idNivel " + idNivel);

		Optional<GalpaoLayout> galpaoLayoutValidado = galpaoLayoutRepository
				.findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(idGalpao, idBloco, idPosicao, idNivel);

		Optional<ControleEntradaProdutoPorPosicao> prodPosicaoValida = prodPosicaoRepository
				.findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(idGalpao, idBloco, idPosicao, idNivel);

		if (prodPosicaoValida.isPresent()) {
			System.out.println("Ocupada");
			return false;
		} else if (galpaoLayoutValidado.isEmpty()) {
			System.out.println("Não existe");
			return false;
		} else if (prodPosicaoValida.isEmpty() && galpaoLayoutValidado.isPresent()) {
			System.out.println("vazia");
			return true;
		} else {
			System.out.println("erro");
			return false;
		}
	}

	// false = etiqueta ainda não posicionada
	// true = etiqueta ja posicionada
	public static Boolean validaEtiqueta(ControleEntradaProdutoPorPosicaoRepository prodPosicaoRepository,
			String EtiquetaProduto, ControleEntradaProdutoEtiquetaRepository prodEtiquetaRepository) {

		List<ControleEntradaProdutoPorPosicao> produtoPosicao = prodPosicaoRepository
				.findByIdEtiqueta(Long.parseLong(EtiquetaProduto));

		Optional<ControleEntradaProdutoEtiqueta> etiquetaEntrada = prodEtiquetaRepository
				.findById(Long.parseLong(EtiquetaProduto));

		if (produtoPosicao.isEmpty() && etiquetaEntrada.isPresent()) {
			System.out.println("não posicionada");
			return true;
		} else if (etiquetaEntrada.isEmpty()) {
			System.out.println("Não existe nota para essa etiqueta");
			return false;
		} else {
			System.out.println("ja posicionada");
			return false;
		}

	}

	public static void posicionaProduto(ControleEntradaProdutoPorPosicaoRepository prodPosicaoRepository,
			String EtiquetaProduto, ControleEntradaColetorRepository controleEntradaColetorRepository,
			GalpaoLayoutRepository galpaoLayoutRepository, String etiquetaPosicionamento,
			ControleEntradaProdutoEtiquetaRepository prodEtiquetaRepository) {

		if (validaPosicao(prodPosicaoRepository, galpaoLayoutRepository, etiquetaPosicionamento) == true
				&& validaEtiqueta(prodPosicaoRepository, EtiquetaProduto, prodEtiquetaRepository) == true) {

			Long idGalpao = Long.parseLong(etiquetaPosicionamento.substring(1, 3));
			Long idBloco = Long.parseLong(etiquetaPosicionamento.substring(3, 6));
			Long idPosicao = Long.parseLong(etiquetaPosicionamento.substring(6, 8));
			Long idNivel = Long.parseLong(etiquetaPosicionamento.substring(8, 10));

			ControleEntradaColetor controleEntradaColetor = controleEntradaColetorRepository
					.findByIdEtiqueta(Long.parseLong(EtiquetaProduto));

			System.out.println("etiqueta: " + EtiquetaProduto);
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
}
