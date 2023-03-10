package com.wms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wms.api.controller.dto.LiberarReterDto;
import com.wms.api.repository.ControleEntradaProdutoPorPosicaoRepository;
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.services.LiberarReterService;

@RestController
@RequestMapping("/liberarReter")
public class LiberarReterController {

	@Autowired
	private NotaFiscalProdutoRepository nfProdutoRepository;

	@Autowired
	private ControleEntradaProdutoPorPosicaoRepository controleEntradaProdutoPorPosicaoRepository;

	@GetMapping
	public Page<LiberarReterDto> listar(@PageableDefault(sort = "id", direction = Direction.DESC) Pageable paginacao,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			LiberarReterService service) {

		return service.liberarReterLista(nfProdutoRepository, paginacao, controleEntradaProdutoPorPosicaoRepository);
	}

}
