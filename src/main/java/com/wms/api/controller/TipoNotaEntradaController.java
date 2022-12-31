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

import com.wms.api.controller.dto.TipoNotaEntradaDto;
import com.wms.api.form.TipoNotaEntradaForm;
import com.wms.api.models.TipoNotaEntrada;
import com.wms.api.repository.TipoNotaEntradaRepository;

@RestController
@RequestMapping("/tiponotaentrada")
public class TipoNotaEntradaController {

	
	@Autowired
	TipoNotaEntradaRepository tipoRepository;
		
	
	
	@GetMapping
	@Transactional
	public List<TipoNotaEntradaDto> listar()	{
		List<TipoNotaEntrada> tipo = tipoRepository.findAll();
		return TipoNotaEntradaDto.converter(tipo);
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<TipoNotaEntradaDto> cadastrar(@RequestBody @Valid TipoNotaEntradaForm form, UriComponentsBuilder uriBuilder) {
		TipoNotaEntrada tipo = form.formulario();
		
		tipoRepository.save(tipo);

		URI uri = uriBuilder.path("/motorista/{id}").buildAndExpand(tipo.getId()).toUri();

		return ResponseEntity.created(uri).body(new TipoNotaEntradaDto(tipo));

	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<TipoNotaEntradaDto> detalhar(@PathVariable Long id) {
		Optional<TipoNotaEntrada> tipo = tipoRepository.findById(id);
		if (tipo.isPresent()) {
			return ResponseEntity.ok(new TipoNotaEntradaDto(tipo.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TipoNotaEntradaDto> atualizar(@PathVariable Long id, @RequestBody @Valid TipoNotaEntradaForm form) {
		Optional<TipoNotaEntrada> optional = tipoRepository.findById(id);
		if (optional.isPresent()) {
			TipoNotaEntrada tipo = form.atualizar(id, tipoRepository);
			return ResponseEntity.ok(new TipoNotaEntradaDto(tipo));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<TipoNotaEntrada> optional = tipoRepository.findById(id);
		if (optional.isPresent()) {

			tipoRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}
}
