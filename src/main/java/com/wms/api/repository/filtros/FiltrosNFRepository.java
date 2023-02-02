package com.wms.api.repository.filtros;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import com.wms.api.models.NotaFiscal;

@Repository
public class FiltrosNFRepository {

	private final EntityManager em;

	public FiltrosNFRepository(EntityManager em) {
		this.em = em;
	}

	@Cacheable(value = "q")
	public Page<NotaFiscal> filtro(String numeroNota, LocalDate dataEmissaoInicio, LocalDate dataEmissaoFim,
			LocalDateTime dataLancamentoInicio, LocalDateTime dataLancamentoFim, Long idTipo, Long idStatusNF,
			Long idCliente,
			@PageableDefault(direction = Direction.DESC, sort = { "dataLancamento" }) Pageable pageable) {

		String query = "Select N from NotaFiscal as N ";
		String condicao = " where";

		if (idTipo != null) {
			query += condicao + " N.idTipoEntrada.id = :idTipo";
			condicao = " and ";
		}

		if (numeroNota != null) {
			query += condicao + " N.numeroNota = :numeroNota";
			condicao = " and ";
		}

		if (idStatusNF != null) {
			query += condicao + " N.idStatusNF.id = :idStatusNF";
			condicao = " and ";
		}

		if (idCliente != null) {
			query += condicao + " N.idCliente.id = :idCliente";
			condicao = " and ";
		}

		if (dataEmissaoInicio != null && dataEmissaoFim != null) {
			query += condicao + " N.dataEmissao between :dataEmissaoInicio and :dataEmissaoFim";
			condicao = " and ";
		}

		if (dataLancamentoInicio != null && dataLancamentoFim != null) {
			query += condicao + " N.dataLancamento between :dataLancamentoInicio and :dataLancamentoFim";
			condicao = " and ";
		}

		query += " order by dataLancamento desc";

		TypedQuery<NotaFiscal> q = em.createQuery(query, NotaFiscal.class);

		if (idTipo != null) {
			q.setParameter("idTipo", idTipo);
		}

		if (numeroNota != null) {
			q.setParameter("numeroNota", numeroNota);
		}

		if (idStatusNF != null) {
			q.setParameter("idStatusNF", idStatusNF);
		}

		if (idCliente != null) {
			q.setParameter("idCliente", idCliente);
		}

		if (dataEmissaoInicio != null && dataEmissaoFim != null) {
			q.setParameter("dataEmissaoInicio", dataEmissaoInicio);
			q.setParameter("dataEmissaoFim", dataEmissaoFim);

		}

		if (dataLancamentoInicio != null && dataLancamentoFim != null) {
			q.setParameter("dataLancamentoInicio", dataLancamentoInicio);
			q.setParameter("dataLancamentoFim", dataLancamentoFim);
		}

		final int start = (int) pageable.getOffset();
		final int toIndex = Math.min(start + pageable.getPageSize(), q.getResultList().size());
		final int fromIndex = Math.max(toIndex - pageable.getPageSize(), 0);
		Page<NotaFiscal> pages = new PageImpl<NotaFiscal>(q.getResultList().subList(fromIndex, toIndex), pageable,
				q.getResultList().size());

		return pages;

	}

}
