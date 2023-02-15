package com.wms.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.GalpaoLayout;

public interface GalpaoLayoutRepository extends JpaRepository<GalpaoLayout, Long> {

	Optional<GalpaoLayout> findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(Long idGalpao, Long idBloco, Long idPosicao,
			Long idNivel);

}
