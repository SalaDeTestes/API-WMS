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
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;

@Service
public class NotaFiscalService {

	public void salvaItemNota(List<NotaFiscalProduto> notaproduto, NotaFiscal nf,
			NotaFiscalProdutoRepository nfprodutoRepository) {

		for (NotaFiscalProduto nfproduto : notaproduto) {
			nfproduto.setIdNotaFiscal(nf);
			nfprodutoRepository.save(nfproduto);
		}
	}

	public void ItensDaNota(NotaFiscal nf, NotaFiscalProdutoRepository nfprodutoRepository) {

		salvaItemNota(nf.getNotaFiscalProduto(), nf, nfprodutoRepository);

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
