package com.wms.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.wms.api.controller.dto.ProdutoDto;
import com.wms.api.form.ProdutoForm;
import com.wms.api.models.Produto;
import com.wms.api.repository.CategoriaGalpaoRepository;
import com.wms.api.repository.ProdutoRepository;
import com.wms.api.repository.UnidadeMedidaRepository;
import com.wms.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	CategoriaGalpaoRepository categoriaGalpaoRepository;
	
	@Autowired
	UnidadeMedidaRepository medidaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	
	
	@GetMapping
	@Transactional
	public List<ProdutoDto> listar()	{
		List<Produto> produto = produtoRepository.findAll();
		return ProdutoDto.converter(produto);
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
		Produto produto = form.formulario(usuarioRepository, medidaRepository, categoriaGalpaoRepository);
		
		produtoRepository.save(produto);

		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();

		return ResponseEntity.created(uri).body(new ProdutoDto(produto));

	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> detalhar(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(new ProdutoDto(produto.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoForm form) {
		Optional<Produto> optional = produtoRepository.findById(id);
		if (optional.isPresent()) {
			Produto produto = form.atualizar(id, produtoRepository, usuarioRepository, medidaRepository, categoriaGalpaoRepository);
			return ResponseEntity.ok(new ProdutoDto(produto));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Produto> optional = produtoRepository.findById(id);
		if (optional.isPresent()) {

			produtoRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}
}
