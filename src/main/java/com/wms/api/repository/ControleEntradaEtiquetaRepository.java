package com.wms.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.ControleEntradaEtiqueta;

public interface ControleEntradaEtiquetaRepository extends JpaRepository<ControleEntradaEtiqueta, Long> {

	Optional<ControleEntradaEtiqueta> findByIdEtiqueta(Long idEtiqueta);

	ControleEntradaEtiqueta findByIdEtiqueta(String etiquetaProduto);

}
