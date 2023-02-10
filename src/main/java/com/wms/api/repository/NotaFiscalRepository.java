package com.wms.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.NotaFiscal;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {

	Page<NotaFiscal> findByEntradaValidadaAndIdStatusNF_IdNotAndNumeroCargaNotNull(boolean b, long l,
			Pageable paginacao);

	NotaFiscal findByNumeroCarga(String numeroCarga);

}
