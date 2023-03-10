package com.wms.api.services;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import com.wms.api.form.ReposicionamentoForm;
import com.wms.api.models.ControleEntradaColetor;
import com.wms.api.models.ControleEntradaProdutoPorPosicao;
import com.wms.api.models.Etiqueta;
import com.wms.api.models.GalpaoLayout;
import com.wms.api.models.TarefaPosicionamento;
import com.wms.api.repository.ControleEntradaColetorRepository;
import com.wms.api.repository.ControleEntradaProdutoEtiquetaRepository;
import com.wms.api.repository.ControleEntradaProdutoPorPosicaoRepository;
import com.wms.api.repository.EtiquetaRepository;
import com.wms.api.repository.GalpaoLayoutRepository;
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;
import com.wms.api.repository.TarefaPosicionamentoRepository;

public class ReposicionamentoService {

	// true = vazia/livre
	public boolean validaPosicao(ControleEntradaProdutoPorPosicaoRepository prodPosicaoRepository,
			GalpaoLayoutRepository galpaoLayoutRepository, String etiquetaPosicionamentoOrigem,
			String etiquetaPosicionamentoDestino, String etiquetaProduto, EtiquetaRepository etiquetaRepository) {

		Long idGalpaoOrigem = Long.parseLong(etiquetaPosicionamentoOrigem.substring(1, 3));
		Long idBlocoOrigem = Long.parseLong(etiquetaPosicionamentoOrigem.substring(3, 6));
		Long idPosicaoOrigem = Long.parseLong(etiquetaPosicionamentoOrigem.substring(6, 8));
		Long idNivelOrigem = Long.parseLong(etiquetaPosicionamentoOrigem.substring(8, 10));

		Long idGalpaoDestino = Long.parseLong(etiquetaPosicionamentoDestino.substring(1, 3));
		Long idBlocoDestino = Long.parseLong(etiquetaPosicionamentoDestino.substring(3, 6));
		Long idPosicaoDestino = Long.parseLong(etiquetaPosicionamentoDestino.substring(6, 8));
		Long idNivelDestino = Long.parseLong(etiquetaPosicionamentoDestino.substring(8, 10));

		System.out.println("idGalpaoOrigem " + idGalpaoOrigem);
		System.out.println("idBlocoOrigem " + idBlocoOrigem);
		System.out.println("idPosiçãoOrigem " + idPosicaoOrigem);
		System.out.println("idNivelOrigem " + idNivelOrigem);

		Optional<GalpaoLayout> galpaoLayoutValidadoDestino = galpaoLayoutRepository
				.findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(idGalpaoDestino, idBlocoDestino, idPosicaoDestino,
						idNivelDestino);

		Optional<GalpaoLayout> galpaoLayoutValidadoOrigem = galpaoLayoutRepository
				.findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(idGalpaoOrigem, idBlocoOrigem, idPosicaoOrigem,
						idNivelOrigem);

		Optional<ControleEntradaProdutoPorPosicao> prodPosicaoValidaOrigem = prodPosicaoRepository
				.findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivelAndIdEtiqueta(idGalpaoOrigem, idBlocoOrigem,
						idPosicaoOrigem, idNivelOrigem, Long.parseLong(etiquetaProduto));

		Optional<ControleEntradaProdutoPorPosicao> prodPosicaoValidaDestino = prodPosicaoRepository
				.findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(idGalpaoDestino, idBlocoDestino, idPosicaoDestino,
						idNivelDestino);

		Optional<Etiqueta> validaEtiqueta = etiquetaRepository.findById(Long.parseLong(etiquetaProduto));

		if (validaEtiqueta.isEmpty()) {
			throw new RuntimeException("A etiqueta " + etiquetaProduto + " não existe ");
		}

		if (prodPosicaoValidaOrigem.isPresent()) {
			System.out.println("Existe o  produto na posição origem" + idGalpaoOrigem + idBlocoOrigem + idPosicaoOrigem
					+ idNivelOrigem);
		}

		if (prodPosicaoValidaDestino.isPresent()) {
			throw new RuntimeException("A  posição de destino: " + idGalpaoDestino + idBlocoDestino + idPosicaoDestino
					+ idNivelDestino + " esta ocupada!");

		} else if (galpaoLayoutValidadoDestino.isEmpty()) {
			System.out.println("Não existe posição de Destino Informada");
			throw new RuntimeException("A  posição de destino: " + idGalpaoDestino + idBlocoDestino + idPosicaoDestino
					+ idNivelDestino + " não existe");

		} else if (galpaoLayoutValidadoOrigem.isEmpty()) {
			throw new RuntimeException("A  posição de origem: " + idGalpaoOrigem + idBlocoOrigem + idPosicaoOrigem
					+ idNivelOrigem + " não existe");

		} else if (prodPosicaoValidaOrigem.isEmpty()) {
			throw new RuntimeException("A etiqueta " + etiquetaProduto + " não está vinculada a posição "
					+ idGalpaoOrigem + idBlocoOrigem + idPosicaoOrigem + idNivelOrigem);

		} else if (prodPosicaoValidaOrigem.isPresent() && galpaoLayoutValidadoDestino.isPresent()
				&& galpaoLayoutValidadoOrigem.isPresent()) {
			System.out.println("Reposicionamento aprovado");
			return true;

		} else {
			System.out.println("erro");
			throw new RuntimeException("Erro não identificado");

		}

	}

	@Transactional
	public void reposicionaProduto(ControleEntradaProdutoPorPosicaoRepository prodPosicaoRepository,
			String EtiquetaProduto, GalpaoLayoutRepository galpaoLayoutRepository, String etiquetaPosicionamentoOrigem,
			String etiquetaPosicionamentoDestino, ControleEntradaProdutoEtiquetaRepository prodEtiquetaRepository,
			NotaFiscalRepository nfRepository, TarefaPosicionamentoRepository tarefaPosicionamentoRepository,
			NotaFiscalProdutoRepository nfProdutoRepository,
			ControleEntradaProdutoPorPosicaoRepository nfProdutoPorPosicaoRepository,
			ControleEntradaColetorRepository controleEntradaColetorRepository, ReposicionamentoForm form,
			EtiquetaRepository etiquetaRepository) {

		if (validaPosicao(prodPosicaoRepository, galpaoLayoutRepository, etiquetaPosicionamentoOrigem,
				etiquetaPosicionamentoDestino, EtiquetaProduto, etiquetaRepository) == true) {

			Long idGalpaoOrigem = Long.parseLong(etiquetaPosicionamentoOrigem.substring(1, 3));
			Long idBlocoOrigem = Long.parseLong(etiquetaPosicionamentoOrigem.substring(3, 6));
			Long idPosicaoOrigem = Long.parseLong(etiquetaPosicionamentoOrigem.substring(6, 8));
			Long idNivelOrigem = Long.parseLong(etiquetaPosicionamentoOrigem.substring(8, 10));

			Long idGalpaoDestino = Long.parseLong(etiquetaPosicionamentoDestino.substring(1, 3));
			Long idBlocoDestino = Long.parseLong(etiquetaPosicionamentoDestino.substring(3, 6));
			Long idPosicaoDestino = Long.parseLong(etiquetaPosicionamentoDestino.substring(6, 8));
			Long idNivelDestino = Long.parseLong(etiquetaPosicionamentoDestino.substring(8, 10));

			Optional<ControleEntradaProdutoPorPosicao> nfProdutoPorPosicao = nfProdutoPorPosicaoRepository
					.findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(idGalpaoOrigem, idBlocoOrigem, idPosicaoOrigem,
							idNivelOrigem);

			System.out.println("Por Posição" + nfProdutoPorPosicao.get().getLote());
			System.out.println("Por Posição" + nfProdutoPorPosicao.get().getIdBloco());
			System.out.println("Por Posição" + nfProdutoPorPosicao.get().getIdGalpao());
			System.out.println("Por Posição" + nfProdutoPorPosicao.get().getIdNivel());
			System.out.println("Por Posição" + nfProdutoPorPosicao.get().getIdPosicao());
			System.out.println("Por Posição" + nfProdutoPorPosicao.get().getIdProduto());
			System.out.println("Por Posição" + nfProdutoPorPosicao.get().getIdNotaFiscal());

			ControleEntradaColetor controleEntradaColetor = controleEntradaColetorRepository
					.findByIdEtiqueta(Long.parseLong(EtiquetaProduto));

			// Atualiza a posição do produto na tabela
			// tbControleEntradaMercadoriaPorPosição
			System.out.println("etiqueta: " + EtiquetaProduto);
			if (nfProdutoPorPosicao.isPresent()) {

				nfProdutoPorPosicao.get().setIdBloco(idBlocoDestino);
				nfProdutoPorPosicao.get().setIdNivel(idNivelDestino);
				nfProdutoPorPosicao.get().setIdGalpao(idGalpaoDestino);
				nfProdutoPorPosicao.get().setIdPosicao(idPosicaoDestino);
				nfProdutoPorPosicao.get().setIdRua((long) 0);
				prodPosicaoRepository.save(nfProdutoPorPosicao.get());
			} else {
				System.out.println("nulo");
			}
			System.out.println("idGalpaoDestino " + idGalpaoDestino);
			System.out.println("idBlocoDestino " + idBlocoDestino);
			System.out.println("idPosiçãoDestino " + idPosicaoDestino);
			System.out.println("idNivelDestino " + idNivelDestino);

			// Cria Tarefa de Posicionamento Pai(Exclusivo do WMS HMS)
			TarefaPosicionamento tarefa = new TarefaPosicionamento();
			tarefa.setIdCliente(
					nfRepository.getReferenceById(controleEntradaColetor.getIdNotaFiscal()).getIdCliente().getId());
			tarefa.setIdStatusTarefa((long) 3);
			tarefa.setIdTipoTarefa((long) 5);
			tarefa.setIdUsuario(nfProdutoPorPosicao.get().getIdUsuario());
			tarefa.setIdUsuarioMov(form.getIdUsuario());
			tarefa.setIdEquipeExec((long) 1);
			tarefa.setIdTipoEquipe((long) 1);
			tarefa.setDataCriacao(LocalDateTime.now());
			tarefa.setDataFim(LocalDateTime.now());
			tarefa.setDataInicio(LocalDateTime.now());
			tarefa.setQtdProduto(nfProdutoPorPosicao.get().getQuantidade());
			tarefa.setNrSeqOrdemTarefa(1);

			tarefa.setIdGalpaoOrigem(idGalpaoOrigem);
			tarefa.setIdBlocoOrigem(idBlocoOrigem);
			tarefa.setIdNivelOrigem(idNivelOrigem);
			tarefa.setIdPosicaoOrigem(idPosicaoOrigem);

			tarefa.setIdGalpaoDestino(idGalpaoDestino);
			tarefa.setIdBlocoDestino(idBlocoDestino);
			tarefa.setIdNivelDestino(idNivelDestino);
			tarefa.setIdPosicaoDestino(idPosicaoDestino);

			tarefa.setIdEtiqueta(Long.parseLong(EtiquetaProduto));
			tarefa.setIdNotaFiscal(nfProdutoPorPosicao.get().getIdNotaFiscal());
			tarefa.setIdProduto(nfProdutoPorPosicao.get().getIdProduto().getId());
			tarefa.setLote(nfProdutoPorPosicao.get().getLote());

			tarefaPosicionamentoRepository.save(tarefa);

		}

	}
}
