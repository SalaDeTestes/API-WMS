package com.wms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.api.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByNome(String nome);

}
