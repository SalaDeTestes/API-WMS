package com.wms.api.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wms.api.controller.dto.NotaFiscalCargaDto;
import com.wms.api.form.NotaFiscalIncluirCargaForm;
import com.wms.api.models.NotaFiscalCarga;
import com.wms.api.repository.DocaRepository;
import com.wms.api.repository.NotaFiscalCargaItensRepository;
import com.wms.api.repository.NotaFiscalCargaRepository;
import com.wms.api.repository.NotaFiscalRepository;
import com.wms.api.services.NotaFiscalCargaService;

@RestController
@RequestMapping("/cargas")
public class NotaFiscalCargaController {

	@Autowired
	NotaFiscalRepository nfRepository;

	@Autowired
	NotaFiscalCargaRepository nfcargaRepository;

	@Autowired
	DocaRepository docaRepository;

	@Autowired
	NotaFiscalCargaItensRepository cargaitensRepository;

	@GetMapping
	@Transactional
	@Cacheable(value = "nfcargaRepository")
	public Page<NotaFiscalCargaDto> listar(Pageable paginacao) {
		return nfcargaRepository.findAll(paginacao).map(NotaFiscalCargaDto::new);

		// http://localhost:8080/notafiscal?size=10&page=3000
		// size = quantidade de elemetos na pagina
		// page = numero atual da pagina
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = {"nfcargaRepository", "docaRepository"}, allEntries = true)
	public ResponseEntity<NotaFiscalCargaDto> cadastrar(@RequestBody @Valid NotaFiscalIncluirCargaForm form,
			NotaFiscalCargaService service, UriComponentsBuilder uriBuilder) {
		NotaFiscalCarga nfcarga = form.formularioNfCarga(docaRepository);

		nfcargaRepository.save(nfcarga);
		service.incluirCarga(form, nfRepository, docaRepository, cargaitensRepository, nfcarga);

		URI uri = uriBuilder.path("/cargas/{id}").buildAndExpand(nfcarga.getId()).toUri();

		return ResponseEntity.created(uri).body(new NotaFiscalCargaDto(nfcarga));

	}

	@GetMapping("/{id}")
	@Transactional
	@Cacheable(value = "nfRepository")
	public ResponseEntity<NotaFiscalCargaDto> detalhar(@PathVariable Long id) {
		Optional<NotaFiscalCarga> nfcarga = nfcargaRepository.findById(id);
		if (nfcarga.isPresent()) {
			return ResponseEntity.ok(new NotaFiscalCargaDto(nfcarga.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "nfRepository", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<NotaFiscalCarga> optional = nfcargaRepository.findById(id);
		if (optional.isPresent()) {

			nfRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}

}
