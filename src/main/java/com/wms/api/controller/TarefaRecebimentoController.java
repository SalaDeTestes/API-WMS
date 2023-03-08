package com.wms.api.controller;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wms.api.controller.dto.ControleRecebimentoDto;
import com.wms.api.controller.dto.NotaFiscalDto;
import com.wms.api.form.ControleRecebimentoForm;
import com.wms.api.models.ControleRecebimento;
import com.wms.api.repository.ControleConferenciaRepository;
import com.wms.api.repository.ControleEntradaColetorRepository;
import com.wms.api.repository.ControleEntradaColetorStatusRepository;
import com.wms.api.repository.ControleEntradaEtiquetaRepository;
import com.wms.api.repository.ControleEntradaProdutoConferenciaRepository;
import com.wms.api.repository.ControleEntradaProdutoEtiquetaRepository;
import com.wms.api.repository.ControleEntradaProdutoPorPosicaoRepository;
import com.wms.api.repository.ControleRecebimentoRepository;
import com.wms.api.repository.DocaRepository;
import com.wms.api.repository.EtiquetaRepository;
import com.wms.api.repository.NotaFiscalProdutoHistoricoRepository;
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;
import com.wms.api.repository.ProdutoRepository;
import com.wms.api.repository.StatusNFRepository;
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
	private ControleEntradaEtiquetaRepository controleEntradaEtiquetaRepository;

	@Autowired
	private ControleEntradaProdutoConferenciaRepository controleEntradaProdutoConferenciaRepository;

	@Autowired
	private ControleEntradaProdutoEtiquetaRepository controleEntradaProdutoEtiquetaRepository;

	@Autowired
	private ControleConferenciaRepository controleConferenciaRepository;

	@Autowired
	private ControleEntradaColetorStatusRepository controleEntradaColetorStatusRepository;

	@Autowired
	private DocaRepository docaRepository;

	@Autowired
	private EtiquetaRepository etiquetaRepository;

	@Autowired
	private NotaFiscalProdutoRepository nfProdutoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private NotaFiscalProdutoHistoricoRepository nfProdutoHistoricoRepository;

	@Autowired
	private StatusNFRepository nfStatusRepository;

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

	@Async
	@PostMapping
	@Transactional
	@CacheEvict(value = "controleRecebimentoRepository", allEntries = true)
	public CompletableFuture<ResponseEntity<ControleRecebimentoDto>> cadastrar(
			@RequestBody @Valid ControleRecebimentoForm form, ControleRecebimentoService service,
			UriComponentsBuilder uriBuilder) {

		ControleRecebimento controleRecebimento = form.formulario();
		service.salvarRecebimento(controleRecebimento, controleRecebimentoRepository, controleEntradaColetorRepository,
				controleEntradaProdutoPorPosicaoRepository, controleEntradaEtiquetaRepository,
				controleEntradaProdutoConferenciaRepository, controleEntradaProdutoEtiquetaRepository,
				controleConferenciaRepository, controleEntradaColetorStatusRepository, nfRepository,
				nfProdutoRepository, docaRepository, etiquetaRepository, produtoRepository,
				nfProdutoHistoricoRepository, nfStatusRepository);

		controleRecebimentoRepository.save(controleRecebimento);

		URI uri = uriBuilder.path("/tarefasrecebimento/{id}").buildAndExpand(controleRecebimento.getId()).toUri();
		return CompletableFuture
				.completedFuture(ResponseEntity.created(uri).body(new ControleRecebimentoDto(controleRecebimento)));

	}

}
