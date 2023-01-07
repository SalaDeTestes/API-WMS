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

import com.wms.api.controller.dto.TipoCaminhaoDto;
import com.wms.api.form.TipoCaminhaoForm;
import com.wms.api.models.TipoCaminhao;
import com.wms.api.repository.TipoCaminhaoRepository;

@RestController
@RequestMapping("/tipocaminhao")
public class TipoCaminhaoController {

	@Autowired
	TipoCaminhaoRepository caminhaoRepository;

	@GetMapping
	@Transactional
	@Cacheable(value = "caminhaoRepository")
	public Page<TipoCaminhaoDto> listar(Pageable paginacao) {

		return caminhaoRepository.findAll(paginacao).map(TipoCaminhaoDto::new);
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "caminhaoRepository", allEntries = true)
	public ResponseEntity<TipoCaminhaoDto> cadastrar(@RequestBody @Valid TipoCaminhaoForm form,
			UriComponentsBuilder uriBuilder) {
		TipoCaminhao caminhao = form.formulario();

		caminhaoRepository.save(caminhao);

		URI uri = uriBuilder.path("/tipocaminhao/{id}").buildAndExpand(caminhao.getId()).toUri();

		return ResponseEntity.created(uri).body(new TipoCaminhaoDto(caminhao));

	}

	@GetMapping("/{id}")
	@Transactional
	@Cacheable(value = "caminhaoRepository")
	public ResponseEntity<TipoCaminhaoDto> detalhar(@PathVariable Long id) {
		Optional<TipoCaminhao> caminhao = caminhaoRepository.findById(id);
		if (caminhao.isPresent()) {
			return ResponseEntity.ok(new TipoCaminhaoDto(caminhao.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CachePut(value = "caminhaoRepository")
	public ResponseEntity<TipoCaminhaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid TipoCaminhaoForm form) {
		Optional<TipoCaminhao> optional = caminhaoRepository.findById(id);
		if (optional.isPresent()) {
			TipoCaminhao caminhao = form.atualizar(id, caminhaoRepository);
			return ResponseEntity.ok(new TipoCaminhaoDto(caminhao));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "caminhaoRepository", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<TipoCaminhao> optional = caminhaoRepository.findById(id);
		if (optional.isPresent()) {

			caminhaoRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}
}
