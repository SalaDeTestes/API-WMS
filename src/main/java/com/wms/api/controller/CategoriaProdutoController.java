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

import com.wms.api.controller.dto.CategoriaProdutoDto;
import com.wms.api.form.CategoriaProdutoForm;
import com.wms.api.models.CategoriaProduto;
import com.wms.api.repository.CategoriaProdutoRepository;

@RestController
@RequestMapping("categoriaproduto")
public class CategoriaProdutoController {

	@Autowired
	CategoriaProdutoRepository categoriaProdutoRepository;

	@GetMapping
	@Transactional
	@Cacheable(value = "clienteRepository")
	public Page<CategoriaProdutoDto> listar(Pageable paginacao) {

		return categoriaProdutoRepository.findAll(paginacao).map(CategoriaProdutoDto::new);
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "categoriaProdutoRepository", allEntries = true)
	public ResponseEntity<CategoriaProdutoDto> cadastrar(@RequestBody @Valid CategoriaProdutoForm form,
			UriComponentsBuilder uriBuilder) {
		CategoriaProduto categoriProduto = form.formulario();

		categoriaProdutoRepository.save(categoriProduto);

		URI uri = uriBuilder.path("/categoriaproduto/{id}").buildAndExpand(categoriProduto.getId()).toUri();

		return ResponseEntity.created(uri).body(new CategoriaProdutoDto(categoriProduto));

	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<CategoriaProdutoDto> detalhar(@PathVariable Long id) {
		Optional<CategoriaProduto> categoriProduto = categoriaProdutoRepository.findById(id);
		if (categoriProduto.isPresent()) {
			return ResponseEntity.ok(new CategoriaProdutoDto(categoriProduto.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CachePut(value = "categoriaProdutoRepository")
	public ResponseEntity<CategoriaProdutoDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid CategoriaProdutoForm form) {
		Optional<CategoriaProduto> optional = categoriaProdutoRepository.findById(id);
		if (optional.isPresent()) {
			CategoriaProduto categoriProduto = form.atualizar(id, categoriaProdutoRepository);
			return ResponseEntity.ok(new CategoriaProdutoDto(categoriProduto));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "categoriaProdutoRepository", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<CategoriaProduto> optional = categoriaProdutoRepository.findById(id);
		if (optional.isPresent()) {

			categoriaProdutoRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}
}
