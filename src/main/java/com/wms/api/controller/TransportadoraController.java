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

import com.wms.api.controller.dto.TransportadoraDto;
import com.wms.api.form.TransportadoraForm;
import com.wms.api.models.Transportadora;
import com.wms.api.repository.TransportadoraRepository;

@RestController
@RequestMapping("/transportadora")
public class TransportadoraController {

	@Autowired
	TransportadoraRepository transportadoraRepository;

	@GetMapping
	@Transactional
	public List<TransportadoraDto> lista(
			String cnpj) {/* String nomeCurso é o parametro passado dentro da URL, cria um filtro */

		if (cnpj == null) {
			List<Transportadora> transportadora = transportadoraRepository.findAll();
			return TransportadoraDto.converter(transportadora);

		} else {

			List<Transportadora> transportadora = transportadoraRepository
					.findByCnpj(cnpj);/*
										 * Metodo criado detro de topicoRepository para busca somente um atributo de uma
										 * entidade(nesse caso especifico busca o nome dentro de uma entidade que se
										 * relaciona com topico findByCursoNome Curso= entidade Nome = atributo de
										 * curso)
										 */
			return TransportadoraDto.converter(transportadora);
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<TransportadoraDto> cadastrar(@RequestBody @Valid TransportadoraForm form,
			UriComponentsBuilder uriBuilder) {

		Transportadora transportadora = form.formulario();
		transportadoraRepository.save(transportadora);

		URI uri = uriBuilder.path("/transportadora/{id}").buildAndExpand(transportadora.getId()).toUri();
		return ResponseEntity.created(uri).body(new TransportadoraDto(transportadora));
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<TransportadoraDto> detalhar(@PathVariable Integer id) {
		Optional<Transportadora> transportadora = transportadoraRepository.findById(id);
		if (transportadora.isPresent()) {
			return ResponseEntity.ok(new TransportadoraDto(transportadora.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TransportadoraDto> atualizar(@PathVariable Integer id,
			@RequestBody @Valid TransportadoraForm form) {
		Optional<Transportadora> optional = transportadoraRepository.findById(id);
		if (optional.isPresent()) {
			Transportadora transportadora = form.atualizar(id, transportadoraRepository);
			return ResponseEntity.ok(new TransportadoraDto(transportadora));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Transportadora> optional = transportadoraRepository.findById(id);
		if (optional.isPresent()) {

			transportadoraRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}

}
