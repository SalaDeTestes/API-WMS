package com.wms.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.ProdutoXCliente;

public interface ProdutoXClienteRepository extends JpaRepository<ProdutoXCliente, Long> {

	Page<ProdutoXCliente> findByIdCliente_Id(Long idCliente, Pageable paginacao);

}
