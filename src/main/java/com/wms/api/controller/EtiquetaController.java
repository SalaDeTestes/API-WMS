package com.wms.api.controller;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.itextpdf.text.DocumentException;
import com.wms.api.controller.dto.EtiquetaDto;
import com.wms.api.models.Etiqueta;
import com.wms.api.repository.EtiquetaRepository;
import com.wms.api.util.PdfGeneratorEtiqueta;

@RestController
@RequestMapping("/etiqueta")
public class EtiquetaController {

	@Autowired
	private EtiquetaRepository etiquetaRepository;

	@GetMapping
	@Transactional
	@Cacheable(value = "etiquetaRepository")
	public Page<EtiquetaDto> lista(@PageableDefault(sort = "id", direction = Direction.DESC) Pageable paginacao) {

		return etiquetaRepository.findAll(paginacao).map(EtiquetaDto::new);

	}

	@GetMapping("/pdf")
	@Transactional
	public void generatePdfFile(@RequestParam int quantidadeEtiqueta,HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=Etiquetas_" + now.format(formatter) + ".pdf";
		response.setHeader(headerkey, headervalue);

		PdfGeneratorEtiqueta generator = new PdfGeneratorEtiqueta();
		generator.GerarEtiquetaPDF(response, quantidadeEtiqueta, etiquetaRepository);
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "etiquetaRepository", allEntries = true)
	public ResponseEntity<EtiquetaDto> cadastrar(UriComponentsBuilder uriBuilder) {

		Etiqueta etiqueta = new Etiqueta();

		etiquetaRepository.save(etiqueta);
		Etiqueta update = etiquetaRepository.getReferenceById(etiqueta.getId());
		update.setDescricaoEtiqueta(etiqueta.getId().toString());

		URI uri = uriBuilder.path("/etiqueta/{id}").buildAndExpand(etiqueta.getId()).toUri();
		return ResponseEntity.created(uri).body(new EtiquetaDto(etiqueta));
	}

	@GetMapping("/{id}")
	@Transactional
	@Cacheable(value = "etiquetaRepository")
	public ResponseEntity<EtiquetaDto> detalhar(@PathVariable Long id) {
		Optional<Etiqueta> etiqueta = etiquetaRepository.findById(id);
		if (etiqueta.isPresent()) {
			return ResponseEntity.ok(new EtiquetaDto(etiqueta.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "docaRepository", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Etiqueta> optional = etiquetaRepository.findById(id);
		if (optional.isPresent()) {

			etiquetaRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}

}
