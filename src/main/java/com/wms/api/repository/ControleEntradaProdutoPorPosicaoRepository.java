package com.wms.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.ControleEntradaProdutoPorPosicao;
import com.wms.api.models.Produto;

public interface ControleEntradaProdutoPorPosicaoRepository
		extends JpaRepository<ControleEntradaProdutoPorPosicao, Long> {

	Optional<ControleEntradaProdutoPorPosicao> findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(Long idGalpao,
			Long idBloco, Long idPosicao, Long idNivel);

	ControleEntradaProdutoPorPosicao findByIdGalpaoAndIdBlocoAndIdNivelAndIdPosicao(Long idGalpao, Long idBloco,
			Long idNivel, Long idPosicao);

	List<ControleEntradaProdutoPorPosicao> findByIdEtiqueta(long parseLong);

	Optional<ControleEntradaProdutoPorPosicao> findByIdNotaFiscalAndIdProdutoAndLote(Long idNotaFiscal, Long idProduto,
			String lote);

	Optional<ControleEntradaProdutoPorPosicao> findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivelAndIdEtiqueta(
			Long idGalpaoOrigem, Long idBlocoOrigem, Long idPosicaoOrigem, Long idNivelOrigem, long parseLong);

	List<ControleEntradaProdutoPorPosicao> findByLoteAndIdProdutoAndIdNotaFiscal(String lote, Produto produto,
			Long notaFiscal);

	List<ControleEntradaProdutoPorPosicao> findByLoteAndIdProdutoAndIdNotaFiscalAndIdEtiquetaIsNotNull(String lote,
			Produto idProduto, Long id);

}
