package com.wms.api.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wms.api.controller.dto.MotoristaDto;
import com.wms.api.form.MotoristaForm;
import com.wms.api.models.Motorista;
import com.wms.api.repository.MotoristaRepository;
import com.wms.api.repository.TransportadoraRepository;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

	@Autowired
	MotoristaRepository motoristaRepository;
	
	@Autowired
	TransportadoraRepository transportadoraRepository;
	
	
	
	@GetMapping
	@Transactional
	@Cacheable(value = "motoristaRepository")
	public Page<MotoristaDto> listar(Pageable paginacao)	{
		
		return motoristaRepository.findAll(paginacao).map(MotoristaDto::new);
				// http://localhost:8080/notafiscal?size=10&page=3000
				// size = quantidade de elemetos na pagina
				// page = numero atual da pagina
	}
	
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "motoristaRepository", allEntries = true)
	public ResponseEntity<MotoristaDto> cadastrar(@RequestBody @Valid MotoristaForm form, UriComponentsBuilder uriBuilder) {
		Motorista motorista = form.formulario(transportadoraRepository);
		
		motoristaRepository.save(motorista);

		URI uri = uriBuilder.path("/motorista/{id}").buildAndExpand(motorista.getId()).toUri();

		return ResponseEntity.created(uri).body(new MotoristaDto(motorista));

	}
	
	@GetMapping("/{id}")
	@Transactional
	@Cacheable(value = "motoristaRepository")
	public ResponseEntity<MotoristaDto> detalhar(@PathVariable Long id) {
		Optional<Motorista> motorista = motoristaRepository.findById(id);
		if (motorista.isPresent()) {
			return ResponseEntity.ok(new MotoristaDto(motorista.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CachePut(value = "motoristaRepository")
	public ResponseEntity<MotoristaDto> atualizar(@PathVariable Long id, @RequestBody @Valid MotoristaForm form) {
		Optional<Motorista> optional = motoristaRepository.findById(id);
		if (optional.isPresent()) {
			Motorista motorista = form.atualizar(id,transportadoraRepository, motoristaRepository);
			return ResponseEntity.ok(new MotoristaDto(motorista));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "motoristaRepository", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Motorista> optional = motoristaRepository.findById(id);
		if (optional.isPresent()) {

			motoristaRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}
}
