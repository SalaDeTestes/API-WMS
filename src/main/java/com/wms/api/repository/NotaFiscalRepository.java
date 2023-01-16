package com.wms.api.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.NotaFiscal;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {

	Page<NotaFiscal> findByNumeroNota(String numeroNota, Pageable paginacao);

	Page<NotaFiscal> findByDataEmissaoBetween(LocalDate dataLancamentoInicio, LocalDate dataLancamentoFim,
			Pageable paginacao);

	Page<NotaFiscal> findByDataLancamentoBetween(LocalDateTime dataLancamentoInicio, LocalDateTime dataLancamentoFim,
			Pageable paginacao);

	Page<NotaFiscal> findByIdTipoEntrada_Id(Long idTipo, Pageable paginacao);

	Page<NotaFiscal> findByIdStatusNF_Id(Long idStatusNF, Pageable paginacao);

	Page<NotaFiscal> findByIdCliente_Id(Long idCliente, Pageable paginacao);

	Page<NotaFiscal> findByNumeroNotaAndDataEmissaoBetween(String numeroNota, LocalDate dataEmissaoInicio,
			LocalDate dataEmissaoFim, Pageable paginacao);

}
