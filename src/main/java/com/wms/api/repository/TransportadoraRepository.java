package com.wms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.Transportadora;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Integer>{

	List<Transportadora> findByCnpj(String cnpj);

	

}
