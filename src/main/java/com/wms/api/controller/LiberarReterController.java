package com.wms.api.controller;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wms.api.controller.dto.LiberarReterDto;
import com.wms.api.models.NotaFiscalProduto;
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;
import com.wms.api.repository.filtros.FiltrosNFProdutoRepository;
import com.wms.api.services.LiberarReterService;

@RestController
@RequestMapping("/liberarReter")
public class LiberarReterController {

	@Autowired
	private NotaFiscalProdutoRepository nfProdutoRepository;

	@Autowired
	private FiltrosNFProdutoRepository filtroRepository;

	@Autowired
	private NotaFiscalRepository nfRepository;

	@GetMapping
	@Transactional
	public Page<LiberarReterDto> listar(
			@PageableDefault(sort = "idNotaFiscalProduto", direction = Direction.DESC) Pageable paginacao,
			LiberarReterService service, @RequestParam(required = false) String codProduto,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFabricacao,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataRecebimento,
			@RequestParam(required = false) String lote, @RequestParam(required = false) Integer tipo,
			@RequestParam(required = false) Long idCliente) {

		return filtroRepository.filtro(codProduto, dataFabricacao, dataRecebimento, lote, tipo, idCliente, paginacao,
				nfProdutoRepository, nfRepository);
	}

	@PutMapping("/{id}/{tipo}")
	@Transactional
	@CacheEvict(value = "entityQuery", allEntries = true)
	public ResponseEntity<NotaFiscalProduto> atualizar(@PathVariable Long id, @PathVariable int tipo,
			LiberarReterService service) {
		Optional<NotaFiscalProduto> optional = nfProdutoRepository.findById(id);
		if (optional.isPresent()) {

			if (tipo == 1) {
				service.liberar(optional.get());

			} else if (tipo == 2) {
				service.reter(optional.get());
			}

			return ResponseEntity.ok(optional.get());
		}

		return ResponseEntity.notFound().build();
	}

}
