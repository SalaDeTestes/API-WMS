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

import com.wms.api.controller.dto.StatusNFDto;
import com.wms.api.form.StatusNFForm;
import com.wms.api.models.StatusNF;
import com.wms.api.repository.StatusNFRepository;

@RestController
@RequestMapping("/status")
public class StatusNFController {

	@Autowired
	private StatusNFRepository statusRepository;

	@GetMapping
	@Transactional
	public List<StatusNFDto> lista(
			String nome) {/* String nomeCurso é o parametro passado dentro da URL, cria um filtro */

		List<StatusNF> status = statusRepository.findAll();
		return StatusNFDto.converter(status);

	}

	@PostMapping
	@Transactional
	public ResponseEntity<StatusNFDto> cadastrar(@RequestBody @Valid StatusNFForm form,
			UriComponentsBuilder uriBuilder) {

		StatusNF status = form.formulario();
		statusRepository.save(status);

		URI uri = uriBuilder.path("/status/{id}").buildAndExpand(status.getId()).toUri();
		return ResponseEntity.created(uri).body(new StatusNFDto(status));
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<StatusNFDto> detalhar(@PathVariable Long id) {
		Optional<StatusNF> pessoas = statusRepository.findById(id);
		if (pessoas.isPresent()) {
			return ResponseEntity.ok(new StatusNFDto(pessoas.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<StatusNFDto> atualizar(@PathVariable Long id, @RequestBody @Valid StatusNFForm form) {
		Optional<StatusNF> optional = statusRepository.findById(id);
		if (optional.isPresent()) {
			StatusNF status = form.atualizar(id, statusRepository);
			return ResponseEntity.ok(new StatusNFDto(status));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<StatusNF> optional = statusRepository.findById(id);
		if (optional.isPresent()) {

			statusRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}

}
