package com.wms.api.services;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.wms.api.controller.dto.NotaFiscalDto;
import com.wms.api.models.NotaFiscal;
import com.wms.api.models.NotaFiscalProduto;
import com.wms.api.models.NotaFiscalProdutoHistorico;
import com.wms.api.repository.NotaFiscalProdutoHistoricoRepository;
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;

@Service
public class NotaFiscalService {

	public void salvaItemNota(List<NotaFiscalProduto> notaproduto, NotaFiscal nf,
			NotaFiscalProdutoRepository nfprodutoRepository,
			NotaFiscalProdutoHistoricoRepository nfProdutoHistoricoRepository) {

		for (NotaFiscalProduto nfproduto : notaproduto) {
			nfproduto.setIdNotaFiscal(nf);
			nfprodutoRepository.save(nfproduto);

			NotaFiscalProdutoHistorico nfProdutoHistorico = new NotaFiscalProdutoHistorico();
			nfProdutoHistorico.setIdNotaFiscal(nfproduto.getIdNotaFiscal().getId());
			nfProdutoHistorico.setLote(nfproduto.getLote());
			nfProdutoHistorico.setIdProduto(nfproduto.getIdProduto().getId());
			nfProdutoHistorico.setPeso(nfproduto.getPesoUnitario());
			nfProdutoHistorico.setEstoqueLiberado(nfproduto.getEstoqueLiberado());
			nfProdutoHistorico.setEstoqueRetido(nfproduto.getEstoqueRetido());
			nfProdutoHistorico.setQuantidadeEstoquePallet((int) (float) nfproduto.getQuantidadePalletsProdutoEstoque());
			nfProdutoHistorico.setQuantidadePallet((int) (float) nfproduto.getQuantidadePalletsProduto());
			nfProdutoHistorico.setQuantidadePalletConferido(nfproduto.getQuantidadePalletProdutoConferido());
			nfProdutoHistorico.setQuantidadeProduto(nfproduto.getQuantidadeProduto());
			nfProdutoHistorico.setQuantidadeProdutoConferida(nfproduto.getQuantidadeUnidadeConferida());
			nfProdutoHistorico.setValorUnitario(nfproduto.getValorUnitario());

			nfProdutoHistoricoRepository.save(nfProdutoHistorico);

		}
	}

	public void ItensDaNota(NotaFiscal nf, NotaFiscalProdutoRepository nfprodutoRepository,
			NotaFiscalProdutoHistoricoRepository nfProdutoHistoricoRepository) {

		salvaItemNota(nf.getNotaFiscalProduto(), nf, nfprodutoRepository, nfProdutoHistoricoRepository);

	}

	@Async
	public void deletar(Long id, NotaFiscalProdutoRepository nfprodutoRepository, NotaFiscalRepository nfRepository) {
		List<NotaFiscalProduto> itens = nfprodutoRepository.findByIdNotaFiscal(nfRepository.getReferenceById(id));

		nfprodutoRepository.deleteAll(itens);
	}

	public ResponseEntity<NotaFiscalDto> atualizacao(NotaFiscal nf) {
		return ResponseEntity.ok(new NotaFiscalDto(nf));
	}

	public ResponseEntity<NotaFiscalDto> AtualizarItensDaNota(Long id, NotaFiscal nf,
			NotaFiscalProdutoRepository nfprodutoRepository, NotaFiscalRepository nfRepository) {

		Runnable salvaItemNota = () -> {

			for (NotaFiscalProduto nfproduto : nf.getNotaFiscalProduto()) {
				nfproduto.setIdNotaFiscal(nf);
				nfprodutoRepository.save(nfproduto);
				atualizacao(nf);
			}

		};

		CyclicBarrier cyclicbarrier = new CyclicBarrier(1, salvaItemNota);

		ExecutorService executor = Executors.newFixedThreadPool(1);
		Runnable r1 = () -> {

			deletar(id, nfprodutoRepository, nfRepository);
			await(cyclicbarrier);
		};

		executor.submit(r1);
		executor.shutdown();

		while (executor.isTerminated() != true) {
			if (executor.isTerminated()) {
				return ResponseEntity.ok(new NotaFiscalDto(nf));
			}
		}

		return ResponseEntity.ok(new NotaFiscalDto(nf));
	}

	private void await(CyclicBarrier cyclicbarrier) {
		try {
			cyclicbarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {

			e.printStackTrace();
		}
	}

}
