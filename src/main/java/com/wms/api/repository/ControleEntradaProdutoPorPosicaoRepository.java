package com.wms.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.ControleEntradaProdutoPorPosicao;

public interface ControleEntradaProdutoPorPosicaoRepository extends JpaRepository<ControleEntradaProdutoPorPosicao, Long> {

	Optional<ControleEntradaProdutoPorPosicao> findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(Long idGalpao,
			Long idBloco, Long idPosicao, Long idNivel);

}
