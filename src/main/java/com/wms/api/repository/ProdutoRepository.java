package com.wms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
