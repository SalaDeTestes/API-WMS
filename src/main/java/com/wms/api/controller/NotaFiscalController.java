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

import com.wms.api.controller.dto.NotaFiscalDto;
import com.wms.api.form.NotaFiscalForm;
import com.wms.api.models.NotaFiscal;
import com.wms.api.repository.ClienteRepository;
import com.wms.api.repository.MotoristaRepository;
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;
import com.wms.api.repository.PlacaTransportadoraRepository;
import com.wms.api.repository.StatusNFRepository;
import com.wms.api.repository.TipoCaminhaoRepository;
import com.wms.api.repository.TipoNotaEntradaRepository;
import com.wms.api.repository.TransportadoraRepository;
import com.wms.api.repository.UsuarioRepository;
import com.wms.api.services.NotaFiscalService;

@RestController
@RequestMapping("/notafiscal")
public class NotaFiscalController {

	@Autowired
	NotaFiscalRepository nfRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	TransportadoraRepository transportadoraRepository;

	@Autowired
	StatusNFRepository statusRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	PlacaTransportadoraRepository placaRepository;

	@Autowired
	MotoristaRepository motoristaRepository;

	@Autowired
	TipoNotaEntradaRepository tipoRepository;

	@Autowired
	TipoCaminhaoRepository caminhaoRepository;

	@Autowired
	NotaFiscalProdutoRepository nfProdutoRepository;

	@GetMapping
	@Transactional
	@Cacheable(value = "nfRepository")
	public Page<NotaFiscalDto> listar(Pageable paginacao) {
		return nfRepository.findAll(paginacao).map(NotaFiscalDto::new);

		// http://localhost:8080/notafiscal?size=10&page=3000
		// size = quantidade de elemetos na pagina
		// page = numero atual da pagina
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "nfRepository", allEntries = true)
	public ResponseEntity<NotaFiscalDto> cadastrar(@RequestBody @Valid NotaFiscalForm form, NotaFiscalService service,
			UriComponentsBuilder uriBuilder) {
		NotaFiscal nf = form.formulario(transportadoraRepository, usuarioRepository, statusRepository,
				clienteRepository, placaRepository, motoristaRepository, tipoRepository, caminhaoRepository);

		nfRepository.save(nf);
		service.ItensDaNota(nf, nfProdutoRepository);

		URI uri = uriBuilder.path("/notafiscal/{id}").buildAndExpand(nf.getId()).toUri();

		return ResponseEntity.created(uri).body(new NotaFiscalDto(nf));

	}

	@GetMapping("/{id}")
	@Transactional
	@Cacheable(value = "nfRepository")
	public ResponseEntity<NotaFiscalDto> detalhar(@PathVariable Long id) {
		Optional<NotaFiscal> nf = nfRepository.findById(id);
		if (nf.isPresent()) {
			return ResponseEntity.ok(new NotaFiscalDto(nf.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CachePut(value = "nfRepository")
	public ResponseEntity<NotaFiscalDto> atualizar(@PathVariable Long id, @RequestBody @Valid NotaFiscalForm form, NotaFiscalService service) {
		Optional<NotaFiscal> optional = nfRepository.findById(id);
		if (optional.isPresent()) {
			NotaFiscal nf = form.atualizar(id, transportadoraRepository, usuarioRepository, statusRepository,
					nfRepository, clienteRepository, placaRepository, motoristaRepository, tipoRepository,
					caminhaoRepository);
			service.AtualizarItensDaNota(id, nf, nfProdutoRepository, nfRepository);
			return ResponseEntity.ok(new NotaFiscalDto(nf));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "nfRepository", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<NotaFiscal> optional = nfRepository.findById(id);
		if (optional.isPresent()) {

			nfRepository.deleteById(id);

			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();
	}

}
