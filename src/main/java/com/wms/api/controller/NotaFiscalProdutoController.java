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

import com.wms.api.controller.dto.NotaFiscalProdutoDto;
import com.wms.api.form.NotaFiscalProdutoForm;
import com.wms.api.models.NotaFiscalProduto;
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;
import com.wms.api.repository.ProdutoRepository;
import com.wms.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/produtosnf")
public class NotaFiscalProdutoController {

	@Autowired
	NotaFiscalRepository nfRepository;

	@Autowired
	NotaFiscalProdutoRepository nfprodutoRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping
	@Transactional
	@Cacheable(value = "nfprodutoRepository")
	public Page<NotaFiscalProdutoDto> listar(Pageable paginacao) {

		return nfprodutoRepository.findAll(paginacao).map(NotaFiscalProdutoDto::new);

	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "nfprodutoRepository", allEntries = true)
	public ResponseEntity<NotaFiscalProdutoDto> cadastrar(@RequestBody @Valid NotaFiscalProdutoForm form,
			UriComponentsBuilder uriBuilder) {
		NotaFiscalProduto nfproduto = form.formulario(nfRepository, produtoRepository);

		nfprodutoRepository.save(nfproduto);

		URI uri = uriBuilder.path("/produtosnf/{id}").buildAndExpand(nfproduto.getId()).toUri();

		return ResponseEntity.created(uri).body(new NotaFiscalProdutoDto(nfproduto));

	}

	@GetMapping("/{id}")
	@Transactional
	@Cacheable(value = "nfprodutoRepository")
	public ResponseEntity<NotaFiscalProdutoDto> detalhar(@PathVariable Long id) {
		Optional<NotaFiscalProduto> nfproduto = nfprodutoRepository.findById(id);
		if (nfproduto.isPresent()) {
			return ResponseEntity.ok(new NotaFiscalProdutoDto(nfproduto.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CachePut(value = "nfprodutoRepository")
	public ResponseEntity<NotaFiscalProdutoDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid NotaFiscalProdutoForm form) {
		Optional<NotaFiscalProduto> optional = nfprodutoRepository.findById(id);
		if (optional.isPresent()) {
			NotaFiscalProduto nfproduto = form.atualizar(id, nfprodutoRepository, nfRepository, produtoRepository);
			return ResponseEntity.ok(new NotaFiscalProdutoDto(nfproduto));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "nfprodutoRepository", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<NotaFiscalProduto> optional = nfprodutoRepository.findById(id);
		if (optional.isPresent()) {

			nfprodutoRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}

}
