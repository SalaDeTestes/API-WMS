package com.wms.api.repository.filtros;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.wms.api.controller.dto.LiberarReterDto;
import com.wms.api.models.ControleEntradaProdutoPorPosicao;
import com.wms.api.models.NotaFiscalProduto;
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;

@Repository
public class FiltrosNFProdutoRepository {

	private final EntityManager em;

	public FiltrosNFProdutoRepository(EntityManager em) {
		this.em = em;
	}

	@Transactional
	@Cacheable(value = "entityQuery")
	public Page<LiberarReterDto> filtro(String codProduto, LocalDate dataFabricacao, LocalDate dataRecebimento,
			String lote, Integer tipo, Long idCliente, Pageable pageable,
			NotaFiscalProdutoRepository nfProdutoRepository, NotaFiscalRepository nfRepository) {

		String query = "SELECT ce FROM ControleEntradaProdutoPorPosicao ce ";
		String condicao = " and ";

		if (idCliente != null) {
			query += "JOIN NotaFiscalProduto nfp ON ce.idNotaFiscal = nfp.idNotaFiscal AND ce.lote = nfp.lote AND ce.idProduto = nfp.idProduto JOIN ProdutoXCliente pxc ON ce.idProduto.id = pxc.idProduto.id ";
			query += "WHERE pxc.idCliente.id = :idCliente and ce.idEtiqueta IS NOT NULL";
		} else {
			query += " JOIN NotaFiscalProduto nfp ON ce.idNotaFiscal = nfp.idNotaFiscal AND ce.lote = nfp.lote AND ce.idProduto = nfp.idProduto WHERE ce.idEtiqueta IS NOT NULL";
		}

		if (codProduto != null) {
			query += condicao + "ce.idProduto.codigoFabricante = :codProduto ";
			condicao = " and ";
		}

		if (dataFabricacao != null) {
			query += condicao + "nfp.dataFabricacao = :dataFabricacao ";
			condicao = " and ";
		}

		LocalDateTime dataInicial = null;
		LocalDateTime dataFinal = null;
		if (dataRecebimento != null) {

			dataInicial = dataRecebimento.atStartOfDay();
			dataFinal = dataInicial.plusDays(1).minusNanos(1);
			query += condicao + "nfp.dataCadastro >= :dataInicial AND nfp.dataCadastro  < :dataFinal ";

			condicao = " and ";
		}

		if (lote != null) {
			query += condicao + "ce.lote = :lote ";
			condicao = " and ";
		}

		if (tipo == null) {
			query += "";

		} else if (tipo == 1) {
			query += condicao + "nfp.estoqueLiberado > 0 and nfp.estoqueRetido <= 0";
			condicao = " and ";
		} else if (tipo == 2) {
			query += condicao + "nfp.estoqueRetido > 0 and nfp.estoqueLiberado <= 0";
			condicao = " and ";
		}

		query += " order by nfp.id desc";

		TypedQuery<ControleEntradaProdutoPorPosicao> entityQuery = em.createQuery(query, ControleEntradaProdutoPorPosicao.class);

		if (idCliente != null) {
			entityQuery.setParameter("idCliente", idCliente);
		}

		if (codProduto != null) {
			entityQuery.setParameter("codProduto", codProduto);
		}

		if (dataFabricacao != null) {
			entityQuery.setParameter("dataFabricacao", dataFabricacao);
		}

		if (dataRecebimento != null) {
			entityQuery.setParameter("dataInicial", dataInicial);
			entityQuery.setParameter("dataFinal", dataFinal);
		}

		if (lote != null) {
			entityQuery.setParameter("lote", lote);
		}

		List<ControleEntradaProdutoPorPosicao> resultList = entityQuery.getResultStream().collect(Collectors.toList());

		List<LiberarReterDto> resultList2 = StreamSupport.stream(resultList.spliterator(), false)
				.skip(pageable.getOffset()).limit(pageable.getPageSize()).map(cep -> {
					NotaFiscalProduto nfp = nfProdutoRepository.findByIdNotaFiscalAndIdProdutoAndLote(
							nfRepository.getReferenceById(cep.getIdNotaFiscal()), cep.getIdProduto(), cep.getLote());

					return new LiberarReterDto(nfp, cep);
				}).collect(Collectors.toList());

		return new PageImpl<>(resultList2, pageable, resultList.size());
	}

}
