package com.wms.api.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.cache.annotation.CacheEvict;

import com.wms.api.models.ControleConferencia;
import com.wms.api.models.ControleEntradaColetor;
import com.wms.api.models.ControleEntradaColetorStatus;
import com.wms.api.models.ControleEntradaEtiqueta;
import com.wms.api.models.ControleEntradaProdutoConferencia;
import com.wms.api.models.ControleEntradaProdutoEtiqueta;
import com.wms.api.models.ControleEntradaProdutoPorPosicao;
import com.wms.api.models.ControleRecebimento;
import com.wms.api.models.Doca;
import com.wms.api.models.Etiqueta;
import com.wms.api.models.NotaFiscal;
import com.wms.api.models.NotaFiscalProduto;
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
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;
import com.wms.api.repository.ProdutoRepository;

public class ControleRecebimentoService {

	@CacheEvict(value = "nfRepository", allEntries = true)
	public void salvarRecebimentoProdutoQuantidadeParcial(ControleRecebimento controleRecebimento,
			ControleRecebimentoRepository controleRecebimentoRepository,
			ControleEntradaColetorRepository entradaColetorRepository,
			ControleEntradaProdutoPorPosicaoRepository controleEntradaProdutoPorPosicaoRepository,
			ControleEntradaEtiquetaRepository controleEntradaEtiquetaRepository,
			ControleEntradaProdutoConferenciaRepository controleEntradaProdutoConferenciaRepository,
			ControleEntradaProdutoEtiquetaRepository controleEntradaProdutoEtiquetaRepository,
			ControleConferenciaRepository controleConferenciaRepository,
			ControleEntradaColetorStatusRepository controleEntradaColetorStatusRepository,
			NotaFiscalRepository nfRepository, DocaRepository docaRepository, EtiquetaRepository etiquetaRepository,
			NotaFiscalProdutoRepository nfProdutoRepository, ProdutoRepository produtoRepository) {

		for (ControleEntradaColetor listcontroleEntradaColetor : controleRecebimento.getControleEntradaColetor()) {
//------------------------------------------------Validação de Etiqueta ------------------------------------------------------------------
			validaEtiqueta(etiquetaRepository, controleEntradaEtiquetaRepository,
					listcontroleEntradaColetor.getIdEtiqueta());

//---------------------------------INSERT Tabela ControleEntradaProdutoEtiqueta -----------------------------------------------------------
			// inserir primeiro aqui
			ControleEntradaProdutoEtiqueta controleEntradaProdutoEtiqueta = new ControleEntradaProdutoEtiqueta();
			controleEntradaProdutoEtiqueta.setDescricaoEtiqueta(listcontroleEntradaColetor.getDescricaoEtiqueta());
			controleEntradaProdutoEtiqueta.setIdEtiqueta(listcontroleEntradaColetor.getIdEtiqueta());
			controleEntradaProdutoEtiqueta.setIdNotaFiscal(listcontroleEntradaColetor.getIdNotaFiscal());

			controleEntradaProdutoEtiquetaRepository.save(controleEntradaProdutoEtiqueta);

//--------------------------------------------------------------------------------------------------------------------------------------

//---------------------------------INSERT Tabela ControleEntradaEtiqueta -----------------------------------------------------------
			ControleEntradaEtiqueta controleEntradaEtiqueta = new ControleEntradaEtiqueta();
			controleEntradaEtiqueta.setIdNotaFiscal(listcontroleEntradaColetor.getIdNotaFiscal());
			controleEntradaEtiqueta.setIdEtiqueta(listcontroleEntradaColetor.getIdEtiqueta());

			controleEntradaEtiquetaRepository.save(controleEntradaEtiqueta);
//--------------------------------------------------------------------------------------------------------------------------------------
// ---------------------------------INSERT Tabela ControleEntradaColetor -----------------------------------------------------------
			entradaColetorRepository.save(listcontroleEntradaColetor);
// ---------------------------------INSERT Tabela ControleEntradaColetorStatus -----------------------------------------------------------

			ControleEntradaColetorStatus controleEntradaColetorStatus = new ControleEntradaColetorStatus();
			controleEntradaColetorStatus.setIdControleColetor(listcontroleEntradaColetor.getId());
			controleEntradaColetorStatus.setIdNotaFiscal(listcontroleEntradaColetor.getIdNotaFiscal());
			controleEntradaColetorStatusRepository.save(controleEntradaColetorStatus);

//--------------------------------------------------------------------------------------------------------------------------------------
		}

		Doca doca = docaRepository.getReferenceById(controleRecebimento.getIdDoca());
		doca.setOcupada(false);
		doca.setNumeroCarga("0");
		doca.setRecebimento(false);

		NotaFiscal nf = nfRepository.findByNumeroCarga(controleRecebimento.getNumeroCarga());
		nf.setEntradaValidada(true);

		ControleConferencia controleConferencia = new ControleConferencia();
		controleConferencia.setIdDoca(controleRecebimento.getIdDoca());
		controleConferencia.setIdUsuario(controleRecebimento.getIdUsuario());
		controleConferencia.setNumeroCarga(controleRecebimento.getNumeroCarga());
		controleConferencia.setDataInicio(controleRecebimento.getDataInicio());
		controleConferenciaRepository.save(controleConferencia);

		atualizaNotaFiscalProduto(nfProdutoRepository, nf.getId(), controleRecebimento, produtoRepository,
				nfRepository);

	}

	@CacheEvict(value = "nfRepository", allEntries = true)
	public void salvarRecebimentoTotal(ControleRecebimento controleRecebimento,
			ControleEntradaProdutoConferenciaRepository controleEntradaProdutoConferenciaRepository,
			NotaFiscalRepository nfRepository,
			ControleEntradaProdutoPorPosicaoRepository controleEntradaProdutoPorPosicaoRepository,
			NotaFiscalProdutoRepository nfprodutoRepository) {

		for (ControleEntradaProdutoConferencia listControleEntradaProdutoConferencia : controleRecebimento
				.getControleEntradaProdutoConferencia()) {

			controleEntradaProdutoConferenciaRepository.save(listControleEntradaProdutoConferencia);

			ControleEntradaProdutoPorPosicao controleEntradaProdutoPorPosicao = new ControleEntradaProdutoPorPosicao();
			controleEntradaProdutoPorPosicao.setIdNotaFiscal(listControleEntradaProdutoConferencia.getIdNotaFiscal());
			controleEntradaProdutoPorPosicao.setIdProduto(listControleEntradaProdutoConferencia.getIdProduto());
			controleEntradaProdutoPorPosicao.setLote(listControleEntradaProdutoConferencia.getLote());
			controleEntradaProdutoPorPosicao.setIdGalpao(nfRepository
					.getReferenceById(listControleEntradaProdutoConferencia.getIdNotaFiscal()).getIdDoca().getId());
			controleEntradaProdutoPorPosicao
					.setQuantidade(listControleEntradaProdutoConferencia.getQuantidadeProdutoConferida());
			controleEntradaProdutoPorPosicao
					.setQuatidadePallets(listControleEntradaProdutoConferencia.getQuantidadePalletConferida());
			controleEntradaProdutoPorPosicao.setIdUsuario(controleRecebimento.getIdUsuario());

			controleEntradaProdutoPorPosicaoRepository.save(controleEntradaProdutoPorPosicao);

		}

	}

	public void atualizaNotaFiscalProduto(NotaFiscalProdutoRepository nfProdutoRepository, Long id,
			ControleRecebimento recebimento, ProdutoRepository produtoRepository, NotaFiscalRepository nfRepository) {

		System.out.println("ponto 1");
		Runnable cadastrarRegistrosAtualizadosLote = () -> {
			System.out.println("ponto 3");
			List<ControleEntradaColetor> produtos = new ArrayList<>();
			List<NotaFiscalProduto> produtos2 = new ArrayList<>();

			for (ControleEntradaColetor lis : recebimento.getControleEntradaColetor()) {
				produtos.add(lis);
			}

			Map<String, Float> quantidades = new HashMap<>();
			Map<String, Integer> pallets = new HashMap<>();
			produtos.forEach(produto -> {
				String chave = produto.getIdProduto() + "-" + produto.getLote();
				quantidades.merge(chave, produto.getQuantidade(), Float::sum);
				pallets.merge(chave, produto.getNumeroPallet(), Integer::sum);

			});
			produtos.forEach(produto -> {
				String chave = produto.getIdProduto() + "-" + produto.getLote();
				if (quantidades.containsKey(chave)) {
					produto.setQuantidade(quantidades.get(chave));
					produto.setNumeroPallet(pallets.get(chave));
					System.out.println("chave: " + quantidades.get(chave));

					NotaFiscalProduto entrada2 = new NotaFiscalProduto();
					entrada2.setIdProduto(produtoRepository.getReferenceById(produto.getIdProduto()));
					entrada2.setLote(produto.getLote());
					entrada2.setQuantidadeProduto(produto.getQuantidade());
					entrada2.setIdNotaFiscal(nfRepository.getReferenceById(produto.getIdNotaFiscal()));
					entrada2.setQuantidadePalletsProduto((float) produto.getNumeroPallet());
					entrada2.setQuantidadePalletsProdutoEstoque((float) produto.getNumeroPallet());
					produtos2.add(entrada2);
					nfProdutoRepository.save(entrada2);
					quantidades.remove(chave);

				}
			});
		};

		CyclicBarrier cyclicbarrier = new CyclicBarrier(1, cadastrarRegistrosAtualizadosLote);

		ExecutorService executor = Executors.newFixedThreadPool(1);
		Runnable r1 = () -> {
			System.out.println("ponto 2");
			deletar(id, nfProdutoRepository);
			await(cyclicbarrier);
		};

		executor.submit(r1);
		executor.shutdown();
	}

	private void await(CyclicBarrier cyclicbarrier) {
		try {
			cyclicbarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {

			e.printStackTrace();
		}
	}

	public void deletar(Long id, NotaFiscalProdutoRepository nfprodutoRepository) {
		List<NotaFiscalProduto> itens = nfprodutoRepository.findByIdNotaFiscal_Id(id);

		nfprodutoRepository.deleteAll(itens);
	}

	public void validaEtiqueta(EtiquetaRepository etiquetaRepository,
			ControleEntradaEtiquetaRepository controleEntradaEtiquetaRepository, Long idEtiqueta) {

		Optional<Etiqueta> etiqueta = etiquetaRepository.findById(idEtiqueta);
		Optional<ControleEntradaEtiqueta> controleEntradaEtiqueta = controleEntradaEtiquetaRepository
				.findByIdEtiqueta(idEtiqueta);

		if (etiqueta.isEmpty()) {
			System.out.println("Inexistene");
			throw new RuntimeException("Etiqueta " + idEtiqueta + " Inexistente");

		} else if (controleEntradaEtiqueta.isPresent()) {
			System.out.println("Vinculada");
			throw new RuntimeException("Etiqueta " + idEtiqueta + " Ja vinculada");

		}

	}

	public void salvarRecebimento(ControleRecebimento controleRecebimento,
			ControleRecebimentoRepository controleRecebimentoRepository,
			ControleEntradaColetorRepository entradaColetorRepository,
			ControleEntradaProdutoPorPosicaoRepository controleEntradaProdutoPorPosicaoRepository,
			ControleEntradaEtiquetaRepository controleEntradaEtiquetaRepository,
			ControleEntradaProdutoConferenciaRepository controleEntradaProdutoConferenciaRepository,
			ControleEntradaProdutoEtiquetaRepository controleEntradaProdutoEtiquetaRepository,
			ControleConferenciaRepository controleConferenciaRepository,
			ControleEntradaColetorStatusRepository controleEntradaColetorStatusRepository,
			NotaFiscalRepository nfRepository, NotaFiscalProdutoRepository nfprodutoRepository,
			DocaRepository docaRepository, EtiquetaRepository etiquetaRepository,
			NotaFiscalProdutoRepository nfProdutoRepository, ProdutoRepository produtoRepository) {
		salvarRecebimentoProdutoQuantidadeParcial(controleRecebimento, controleRecebimentoRepository,
				entradaColetorRepository, controleEntradaProdutoPorPosicaoRepository, controleEntradaEtiquetaRepository,
				controleEntradaProdutoConferenciaRepository, controleEntradaProdutoEtiquetaRepository,
				controleConferenciaRepository, controleEntradaColetorStatusRepository, nfRepository, docaRepository,
				etiquetaRepository, nfProdutoRepository, produtoRepository);
		salvarRecebimentoTotal(controleRecebimento, controleEntradaProdutoConferenciaRepository, nfRepository,
				controleEntradaProdutoPorPosicaoRepository, nfprodutoRepository);
	}

}
