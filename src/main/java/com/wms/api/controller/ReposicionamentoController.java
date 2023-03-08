package com.wms.api.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wms.api.form.ReposicionamentoForm;
import com.wms.api.models.ControleEntradaProdutoPorPosicao;
import com.wms.api.repository.ControleEntradaColetorRepository;
import com.wms.api.repository.ControleEntradaProdutoEtiquetaRepository;
import com.wms.api.repository.ControleEntradaProdutoPorPosicaoRepository;
import com.wms.api.repository.EtiquetaRepository;
import com.wms.api.repository.GalpaoLayoutRepository;
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;
import com.wms.api.repository.TarefaPosicionamentoRepository;
import com.wms.api.services.ReposicionamentoService;

@RestController
@RequestMapping("/reposicionar")
public class ReposicionamentoController {

	@Autowired
	private GalpaoLayoutRepository galpaoLayoutRepository;

	@Autowired
	private ControleEntradaProdutoEtiquetaRepository prodEtiquetaRepository;

	@Autowired
	private ControleEntradaProdutoPorPosicaoRepository prodPosicaoRepository;

	@Autowired
	private ControleEntradaColetorRepository controleEntradaColetorRepository;

	@Autowired
	private TarefaPosicionamentoRepository tarefaPosicionamentoRepository;

	@Autowired
	private NotaFiscalRepository nfRepository;

	@Autowired
	private NotaFiscalProdutoRepository nfProdutoRepository;

	@Autowired
	private ControleEntradaProdutoPorPosicaoRepository nfProdutoPorPosicaoRepository;

	@Autowired
	private EtiquetaRepository etiquetaRepository;

	@PostMapping
	@Transactional
	@CacheEvict(value = "clienteRepository", allEntries = true)
	public ResponseEntity<ControleEntradaProdutoPorPosicao/* Dto */> cadastrar(
			@RequestBody @Valid ReposicionamentoForm form, ReposicionamentoService service,
			UriComponentsBuilder uriBuilder) {
		ReposicionamentoForm reposicionamentoform = form.formulario();

		service.reposicionaProduto(prodPosicaoRepository, reposicionamentoform.getEtiquetaProduto(),
				galpaoLayoutRepository, reposicionamentoform.getEtiquetaPosicionamentoOrigem(),
				reposicionamentoform.getEtiquetaPosicionamentoDestino(), prodEtiquetaRepository, nfRepository,
				tarefaPosicionamentoRepository, nfProdutoRepository, nfProdutoPorPosicaoRepository,
				controleEntradaColetorRepository, form, etiquetaRepository);

		Long idGalpao = Long.parseLong(reposicionamentoform.getEtiquetaPosicionamentoDestino().substring(1, 3));
		Long idBloco = Long.parseLong(reposicionamentoform.getEtiquetaPosicionamentoDestino().substring(3, 6));
		Long idPosicao = Long.parseLong(reposicionamentoform.getEtiquetaPosicionamentoDestino().substring(6, 8));
		Long idNivel = Long.parseLong(reposicionamentoform.getEtiquetaPosicionamentoDestino().substring(8, 10));

		ControleEntradaProdutoPorPosicao prodPosicao = prodPosicaoRepository
				.findByIdGalpaoAndIdBlocoAndIdNivelAndIdPosicao(idGalpao, idBloco, idNivel, idPosicao);

		URI uri = uriBuilder.path("/posicionar/{id}").buildAndExpand(prodPosicao.getId()).toUri();

		return ResponseEntity.created(uri).body(prodPosicao);

	}
}
