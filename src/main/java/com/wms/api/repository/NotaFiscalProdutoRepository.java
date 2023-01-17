package com.wms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.NotaFiscal;
import com.wms.api.models.NotaFiscalProduto;

public interface NotaFiscalProdutoRepository extends JpaRepository<NotaFiscalProduto, Long> {

	List<NotaFiscalProduto> findByIdNotaFiscal(NotaFiscal idNotaFiscal);

}
