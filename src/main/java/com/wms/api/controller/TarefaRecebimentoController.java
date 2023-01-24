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

import com.wms.api.controller.dto.ControleRecebimentoDto;
import com.wms.api.controller.dto.DocaDto;
import com.wms.api.controller.dto.NotaFiscalDto;
import com.wms.api.form.ControleRecebimentoForm;
import com.wms.api.form.DocaForm;
import com.wms.api.models.ControleRecebimento;
import com.wms.api.models.Doca;
import com.wms.api.repository.ControleEntradaColetorRepository;
import com.wms.api.repository.ControleEntradaEtiquetaRepository;
import com.wms.api.repository.ControleEntradaProdutoConferenciaRepository;
import com.wms.api.repository.ControleEntradaProdutoPorPosicaoRepository;
import com.wms.api.repository.ControleRecebimentoRepository;
import com.wms.api.repository.DocaRepository;
import com.wms.api.repository.NotaFiscalRepository;
import com.wms.api.repository.ProdutoRepository;
import com.wms.api.repository.UsuarioRepository;
import com.wms.api.services.ControleRecebimentoService;

@RestController
@RequestMapping("/tarefasrecebimento")
public class TarefaRecebimentoController {

	@Autowired
	private NotaFiscalRepository nfRepository;

	@Autowired
	private ControleRecebimentoRepository controleRecebimentoRepository;

	@Autowired
	private ControleEntradaColetorRepository controleEntradaColetorRepository;

	@Autowired
	private ControleEntradaProdutoPorPosicaoRepository controleEntradaProdutoPorPosicaoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ControleEntradaEtiquetaRepository controleEntradaEtiquetaRepository;

	@Autowired
	private ControleEntradaProdutoConferenciaRepository controleEntradaProdutoConferenciaRepository;

	@GetMapping
	@Transactional
	@Cacheable(value = "nfRepository")
	public Page<NotaFiscalDto> lista(Pageable paginacao) {

		return nfRepository
				.findByEntradaValidadaAndIdStatusNF_IdNotAndNumeroCargaNotNull((boolean) false, (long) 3, paginacao)
				.map(NotaFiscalDto::new);
	}

	@GetMapping("/recebimento")
	@Transactional
	@Cacheable(value = "controleRecebimentoRepository")
	public Page<ControleRecebimentoDto> lista2(Pageable paginacao) {

		return controleRecebimentoRepository.findAll(paginacao).map(ControleRecebimentoDto::new);
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "controleRecebimentoRepository", allEntries = true)
	public ResponseEntity<ControleRecebimentoDto> cadastrar(@RequestBody @Valid ControleRecebimentoForm form,
			ControleRecebimentoService service, UriComponentsBuilder uriBuilder) {

		ControleRecebimento controleRecebimento = form.formulario();
		service.salvarRecebimento(controleRecebimento, controleRecebimentoRepository, controleEntradaColetorRepository,
				produtoRepository, controleEntradaProdutoPorPosicaoRepository, controleEntradaEtiquetaRepository,
				controleEntradaProdutoConferenciaRepository);
		controleRecebimentoRepository.save(controleRecebimento);

		URI uri = uriBuilder.path("/tarefasrecebimento/{id}").buildAndExpand(controleRecebimento.getId()).toUri();
		return ResponseEntity.created(uri).body(new ControleRecebimentoDto(controleRecebimento));
	}

//	@GetMapping("/{id}")
//	@Transactional
//	@Cacheable(value = "docaRepository")
//	public ResponseEntity<DocaDto> detalhar(@PathVariable Long id) {
//		Optional<Doca> doca = docaRepository.findById(id);
//		if (doca.isPresent()) {
//			return ResponseEntity.ok(new DocaDto(doca.get()));
//		}
//
//		return ResponseEntity.notFound().build();
//	}
//
//	@PutMapping("/{id}")
//	@Transactional
//	@CachePut(value = "docaRepository")
//	public ResponseEntity<DocaDto> atualizar(@PathVariable Long id, @RequestBody @Valid DocaForm form) {
//		Optional<Doca> optional = docaRepository.findById(id);
//		if (optional.isPresent()) {
//			Doca doca = form.atualizar(id, docaRepository);
//			return ResponseEntity.ok(new DocaDto(doca));
//		}
//
//		return ResponseEntity.notFound().build();
//	}
//
//	@DeleteMapping("/{id}")
//	@Transactional
//	@CacheEvict(value = "docaRepository", allEntries = true)
//	public ResponseEntity<?> remover(@PathVariable Long id) {
//		Optional<Doca> optional = docaRepository.findById(id);
//		if (optional.isPresent()) {
//
//			docaRepository.deleteById(id);
//
//			return ResponseEntity.ok().build();
//
//		}
//
//		return ResponseEntity.notFound().build();
//	}
}
