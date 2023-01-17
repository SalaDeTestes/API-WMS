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

import com.wms.api.controller.dto.DocaDto;
import com.wms.api.form.DocaForm;
import com.wms.api.models.Doca;
import com.wms.api.repository.DocaRepository;

@RestController
@RequestMapping("/doca")
public class DocaController {

	@Autowired
	private DocaRepository docaRepository;

	@GetMapping
	@Transactional
	@Cacheable(value = "docaRepository")
	public Page<DocaDto> lista(Pageable paginacao) {

		return docaRepository.findAll(paginacao).map(DocaDto::new);

	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "docaRepository", allEntries = true)
	public ResponseEntity<DocaDto> cadastrar(@RequestBody @Valid DocaForm form, UriComponentsBuilder uriBuilder) {

		Doca status = form.formulario();
		docaRepository.save(status);

		URI uri = uriBuilder.path("/doca/{id}").buildAndExpand(status.getId()).toUri();
		return ResponseEntity.created(uri).body(new DocaDto(status));
	}

	@GetMapping("/{id}")
	@Transactional
	@Cacheable(value = "docaRepository")
	public ResponseEntity<DocaDto> detalhar(@PathVariable Long id) {
		Optional<Doca> pessoas = docaRepository.findById(id);
		if (pessoas.isPresent()) {
			return ResponseEntity.ok(new DocaDto(pessoas.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CachePut(value = "docaRepository")
	public ResponseEntity<DocaDto> atualizar(@PathVariable Long id, @RequestBody @Valid DocaForm form) {
		Optional<Doca> optional = docaRepository.findById(id);
		if (optional.isPresent()) {
			Doca status = form.atualizar(id, docaRepository);
			return ResponseEntity.ok(new DocaDto(status));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "docaRepository", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Doca> optional = docaRepository.findById(id);
		if (optional.isPresent()) {

			docaRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}

}
