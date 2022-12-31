package com.wms.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.Transportadora;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Long>{

	List<Transportadora> findByCnpj(String cnpj);

	Optional<Transportadora> findById(Integer id);

	Transportadora getReferenceById(Integer id);

}
