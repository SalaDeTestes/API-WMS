package com.wms.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.NotaFiscal;
import com.wms.api.models.NotaFiscalProduto;
import com.wms.api.models.Produto;


public interface NotaFiscalProdutoRepository extends JpaRepository<NotaFiscalProduto, Long> {

	List<NotaFiscalProduto> findByIdNotaFiscal(NotaFiscal idNotaFiscal);

	List<NotaFiscalProduto> findByIdNotaFiscal_Id(Long id);

	List<NotaFiscalProduto> findByIdNotaFiscalAndIdProduto(Long id, Long id2);

	Optional<NotaFiscalProduto> findByIdNotaFiscal_IdAndIdProduto_IdAndLote(Long idNotaFiscal, Long idProduto,
			String lote);

	NotaFiscalProduto findByIdNotaFiscalAndIdProdutoAndLote(NotaFiscal notaFiscal, Produto produto, String lote);

}
