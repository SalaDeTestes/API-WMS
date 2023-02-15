package com.wms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.ControleEntradaColetor;

public interface ControleEntradaColetorRepository extends JpaRepository<ControleEntradaColetor, Long>{

	ControleEntradaColetor findByIdEtiqueta(long parseLong);

}
