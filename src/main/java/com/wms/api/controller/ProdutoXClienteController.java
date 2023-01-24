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
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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

import com.wms.api.controller.dto.ProdutoXClienteDto;
import com.wms.api.form.ProdutoXClienteForm;
import com.wms.api.models.ProdutoXCliente;
import com.wms.api.repository.CategoriaProdutoRepository;
import com.wms.api.repository.ClienteRepository;
import com.wms.api.repository.ProdutoRepository;
import com.wms.api.repository.ProdutoXClienteRepository;


@RestController
@RequestMapping("/produtoxcliente")
public class ProdutoXClienteController {

	@Autowired
	ProdutoXClienteRepository produtoClienteRepository;

	@Autowired
	ClienteRepository clienteRepository;


	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	CategoriaProdutoRepository categoriaProdutoRepository;

	@GetMapping
	@Transactional
	@Cacheable(value = "produtoClienteRepository")
	public Page<ProdutoXClienteDto> listar(
			@PageableDefault(direction = Direction.ASC, sort = { "id" }) Pageable paginacao) {

		return produtoClienteRepository.findAll(paginacao).map(ProdutoXClienteDto::new);
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "produtoClienteRepository", allEntries = true)
	public ResponseEntity<ProdutoXClienteDto> cadastrar(@RequestBody @Valid ProdutoXClienteForm form,
			UriComponentsBuilder uriBuilder) {
		ProdutoXCliente produtoCliente = form.formulario(clienteRepository, produtoRepository, categoriaProdutoRepository);

		produtoClienteRepository.save(produtoCliente);

		URI uri = uriBuilder.path("/produtoxcliente/{id}").buildAndExpand(produtoCliente.getId()).toUri();

		return ResponseEntity.created(uri).body(new ProdutoXClienteDto(produtoCliente));

	}

	@GetMapping("/{id}")
	@Transactional
	@Cacheable(value = "produtoClienteRepository")
	public ResponseEntity<ProdutoXClienteDto> detalhar(@PathVariable Long id) {
		Optional<ProdutoXCliente> produtoCliente = produtoClienteRepository.findById(id);
		if (produtoCliente.isPresent()) {
			return ResponseEntity.ok(new ProdutoXClienteDto(produtoCliente.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CachePut(value = "produtoClienteRepository")
	public ResponseEntity<ProdutoXClienteDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid ProdutoXClienteForm form) {
		Optional<ProdutoXCliente> optional = produtoClienteRepository.findById(id);
		if (optional.isPresent()) {
			ProdutoXCliente produto = form.atualizar(id, produtoClienteRepository, clienteRepository,
					produtoRepository, categoriaProdutoRepository);
			return ResponseEntity.ok(new ProdutoXClienteDto(produto));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "produtoClienteRepository", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<ProdutoXCliente> optional = produtoClienteRepository.findById(id);
		if (optional.isPresent()) {

			produtoClienteRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}
}
