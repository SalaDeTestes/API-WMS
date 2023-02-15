package com.wms.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.PlacaTransportadora;

public interface PlacaTransportadoraRepository extends JpaRepository<PlacaTransportadora, Long> {

	PlacaTransportadora findById(String id);

	Page<PlacaTransportadora> findByIdTransportadora_Id(Integer idTransportadora, Pageable paginacao);

}
