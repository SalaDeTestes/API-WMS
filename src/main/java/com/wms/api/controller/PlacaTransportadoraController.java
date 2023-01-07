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

import com.wms.api.controller.dto.PlacaTransportadoraDto;
import com.wms.api.form.PlacaTransportadoraForm;
import com.wms.api.models.PlacaTransportadora;
import com.wms.api.repository.PlacaTransportadoraRepository;
import com.wms.api.repository.TransportadoraRepository;

@RestController
@RequestMapping("/placa")
public class PlacaTransportadoraController {

	@Autowired
	private PlacaTransportadoraRepository placaRepository;

	@Autowired
	private TransportadoraRepository transportadoraRepository;

	@GetMapping
	@Transactional
	@Cacheable(value = "placaRepository")
	public Page<PlacaTransportadoraDto> lista(Pageable paginacao) {

		return placaRepository.findAll(paginacao).map(PlacaTransportadoraDto::new);
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "placaRepository", allEntries = true)
	public ResponseEntity<PlacaTransportadoraDto> cadastrar(@RequestBody @Valid PlacaTransportadoraForm form,
			UriComponentsBuilder uriBuilder) {

		PlacaTransportadora placa = form.formulario(transportadoraRepository);
		placaRepository.save(placa);

		URI uri = uriBuilder.path("/placa/{id}").buildAndExpand(placa.getId()).toUri();
		return ResponseEntity.created(uri).body(new PlacaTransportadoraDto(placa));
	}

	@GetMapping("/{id}")
	@Transactional
	@Cacheable(value = "placaRepository")
	public ResponseEntity<PlacaTransportadoraDto> detalhar(@PathVariable Long id) {
		Optional<PlacaTransportadora> placa = placaRepository.findById(id);
		if (placa.isPresent()) {
			return ResponseEntity.ok(new PlacaTransportadoraDto(placa.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CachePut(value = "placaRepository")
	public ResponseEntity<PlacaTransportadoraDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid PlacaTransportadoraForm form) {
		Optional<PlacaTransportadora> optional = placaRepository.findById(id);
		if (optional.isPresent()) {
			PlacaTransportadora placa = form.atualizar(id, transportadoraRepository, placaRepository);
			return ResponseEntity.ok(new PlacaTransportadoraDto(placa));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "placaRepository", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<PlacaTransportadora> optional = placaRepository.findById(id);
		if (optional.isPresent()) {

			placaRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}
}
