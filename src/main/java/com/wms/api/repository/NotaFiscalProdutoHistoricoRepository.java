package com.wms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.NotaFiscalProdutoHistorico;

public interface NotaFiscalProdutoHistoricoRepository extends JpaRepository<NotaFiscalProdutoHistorico, Long> {

	NotaFiscalProdutoHistorico findByIdNotaFiscalAndIdProduto(Long id, Long id2);

}
