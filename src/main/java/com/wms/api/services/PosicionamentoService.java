package com.wms.api.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.wms.api.models.ControleEntradaColetor;
import com.wms.api.models.ControleEntradaProdutoEtiqueta;
import com.wms.api.models.ControleEntradaProdutoPorPosicao;
import com.wms.api.models.GalpaoLayout;
import com.wms.api.models.NotaFiscalProduto;
import com.wms.api.models.TarefaPosicionamento;
import com.wms.api.repository.ControleEntradaColetorRepository;
import com.wms.api.repository.ControleEntradaProdutoEtiquetaRepository;
import com.wms.api.repository.ControleEntradaProdutoPorPosicaoRepository;
import com.wms.api.repository.GalpaoLayoutRepository;
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;
import com.wms.api.repository.TarefaPosicionamentoRepository;

@Service
@Transactional
public class PosicionamentoService {

	// False = ocupada/não existe/erro
	// true = vazia/livre
	public static boolean validaPosicao(ControleEntradaProdutoPorPosicaoRepository prodPosicaoRepository,
			GalpaoLayoutRepository galpaoLayoutRepository, String etiquetaPosicionamento) {

		Long idGalpao = Long.parseLong(etiquetaPosicionamento.substring(1, 3));
		Long idBloco = Long.parseLong(etiquetaPosicionamento.substring(3, 6));
		Long idPosicao = Long.parseLong(etiquetaPosicionamento.substring(6, 8));
		Long idNivel = Long.parseLong(etiquetaPosicionamento.substring(8, 10));

		System.out.println("idGalpao " + idGalpao);
		System.out.println("idBloco " + idBloco);
		System.out.println("idPosição " + idPosicao);
		System.out.println("idNivel " + idNivel);

		Optional<GalpaoLayout> galpaoLayoutValidado = galpaoLayoutRepository
				.findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(idGalpao, idBloco, idPosicao, idNivel);

		Optional<ControleEntradaProdutoPorPosicao> prodPosicaoValida = prodPosicaoRepository
				.findByIdGalpaoAndIdBlocoAndIdPosicaoAndIdNivel(idGalpao, idBloco, idPosicao, idNivel);

		if (prodPosicaoValida.isPresent()) {
			System.out.println("Ocupada");
			return false;
		} else if (galpaoLayoutValidado.isEmpty()) {
			System.out.println("Não existe");
			return false;
		} else if (prodPosicaoValida.isEmpty() && galpaoLayoutValidado.isPresent()) {
			System.out.println("vazia");
			return true;
		} else {
			System.out.println("erro");
			return false;
		}
	}

	// false = etiqueta ainda não posicionada
	// true = etiqueta ja posicionada
	public static Boolean validaEtiqueta(ControleEntradaProdutoPorPosicaoRepository prodPosicaoRepository,
			String EtiquetaProduto, ControleEntradaProdutoEtiquetaRepository prodEtiquetaRepository) {

		List<ControleEntradaProdutoPorPosicao> produtoPosicao = prodPosicaoRepository
				.findByIdEtiqueta(Long.parseLong(EtiquetaProduto));

		Optional<ControleEntradaProdutoEtiqueta> etiquetaEntrada = prodEtiquetaRepository
				.findById(Long.parseLong(EtiquetaProduto));

		if (produtoPosicao.isEmpty() && etiquetaEntrada.isPresent()) {
			System.out.println("não posicionada");
			return true;
		} else if (etiquetaEntrada.isEmpty()) {
			System.out.println("Não existe nota para essa etiqueta");
			return false;
		} else {
			System.out.println("ja posicionada");
			return false;
		}

	}

	public void posicionaProduto(ControleEntradaProdutoPorPosicaoRepository prodPosicaoRepository,
			String EtiquetaProduto, ControleEntradaColetorRepository controleEntradaColetorRepository,
			GalpaoLayoutRepository galpaoLayoutRepository, String etiquetaPosicionamento,
			ControleEntradaProdutoEtiquetaRepository prodEtiquetaRepository, NotaFiscalRepository nfRepository,
			TarefaPosicionamentoRepository tarefaPosicionamentoRepository,
			NotaFiscalProdutoRepository nfProdutoRepository) {

		if (validaPosicao(prodPosicaoRepository, galpaoLayoutRepository, etiquetaPosicionamento) == true
				&& validaEtiqueta(prodPosicaoRepository, EtiquetaProduto, prodEtiquetaRepository) == true) {

			Long idGalpao = Long.parseLong(etiquetaPosicionamento.substring(1, 3));
			Long idBloco = Long.parseLong(etiquetaPosicionamento.substring(3, 6));
			Long idPosicao = Long.parseLong(etiquetaPosicionamento.substring(6, 8));
			Long idNivel = Long.parseLong(etiquetaPosicionamento.substring(8, 10));

			ControleEntradaColetor controleEntradaColetor = controleEntradaColetorRepository
					.findByIdEtiqueta(Long.parseLong(EtiquetaProduto));
			
			//cria o registro do produto ja com sua posição na tabela tbControleEntradaMercadoriaPorPosição
			System.out.println("etiqueta: " + EtiquetaProduto);
			ControleEntradaProdutoPorPosicao prodPosicao = new ControleEntradaProdutoPorPosicao();
			prodPosicao.setIdProduto(controleEntradaColetor.getIdProduto());
			prodPosicao.setIdEtiqueta(controleEntradaColetor.getIdEtiqueta());
			prodPosicao.setIdNotaFiscal(controleEntradaColetor.getIdNotaFiscal());
			prodPosicao.setQuantidade(controleEntradaColetor.getQuantidade());
			prodPosicao.setIdStatusMovimentacao((long) 2);
			prodPosicao.setQuatidadePallets(controleEntradaColetor.getNumeroPallet());
			prodPosicao.setIdUsuario(controleEntradaColetor.getIdUsuario());
			prodPosicao.setLote(controleEntradaColetor.getLote());
			prodPosicao.setIdRua((long) 0);
			prodPosicao.setNumeroSaidasEmAberto(0);
			prodPosicao.setIdBloco(idBloco);
			prodPosicao.setIdNivel(idNivel);
			prodPosicao.setIdGalpao(idGalpao);
			prodPosicao.setIdPosicao(idPosicao);

			prodPosicaoRepository.save(prodPosicao);

			//Cria Tarefa de Posicionamento Pai(Exclusivo do WMS HMS)
			TarefaPosicionamento tarefaPai = new TarefaPosicionamento();
			tarefaPai.setIdCliente(
					nfRepository.getReferenceById(controleEntradaColetor.getIdNotaFiscal()).getIdCliente().getId());
			tarefaPai.setIdStatusTarefa((long) 3);
			tarefaPai.setIdTipoTarefa((long) 2);
			tarefaPai.setIdUsuario(controleEntradaColetor.getIdUsuario());
			tarefaPai.setIdUsuarioMov(controleEntradaColetor.getIdUsuario());
			tarefaPai.setIdEquipeExec((long) 1);
			tarefaPai.setIdTipoEquipe((long) 1);
			tarefaPai.setDataCriacao(LocalDateTime.now());
			tarefaPai.setDataFim(LocalDateTime.now());
			tarefaPai.setDataInicio(LocalDateTime.now());
			tarefaPai.setNrSeqOrdemTarefa(1);
			tarefaPai.setIdGalpaoOrigem(controleEntradaColetor.getIdDoca());
			tarefaPai.setIdGalpaoDestino(idGalpao);
			tarefaPai.setIdBlocoDestino(idBloco);
			tarefaPai.setIdEtiqueta(Long.parseLong(EtiquetaProduto));
			tarefaPai.setIdNotaFiscal(controleEntradaColetor.getIdNotaFiscal());
			tarefaPai.setIdProduto(controleEntradaColetor.getIdProduto());
			tarefaPai.setLote(controleEntradaColetor.getLote());

			tarefaPosicionamentoRepository.save(tarefaPai);

			//Cria Tarefa de Posicionamento Filho(Exclusivo do WMS HMS)
			TarefaPosicionamento tarefaFilho = new TarefaPosicionamento();
			tarefaFilho.setIdCliente(
					nfRepository.getReferenceById(controleEntradaColetor.getIdNotaFiscal()).getIdCliente().getId());
			tarefaFilho.setIdStatusTarefa((long) 3);
			tarefaFilho.setIdTipoTarefa((long) 2);
			tarefaFilho.setIdUsuario(controleEntradaColetor.getIdUsuario());
			tarefaFilho.setIdUsuarioMov(controleEntradaColetor.getIdUsuario());
			tarefaFilho.setIdEquipeExec((long) 1);
			tarefaFilho.setIdTipoEquipe((long) 2);
			tarefaFilho.setDataCriacao(LocalDateTime.now());
			tarefaFilho.setDataFim(LocalDateTime.now());
			tarefaFilho.setDataInicio(LocalDateTime.now());
			tarefaFilho.setNrSeqOrdemTarefa(2);
			tarefaFilho.setNrSeqTarefaPai(tarefaPai.getId());
			tarefaFilho.setIdGalpaoOrigem(idGalpao);
			tarefaFilho.setIdGalpaoDestino(idGalpao);
			tarefaFilho.setIdBlocoOrigem(idBloco);
			tarefaFilho.setIdBlocoDestino(idBloco);
			tarefaFilho.setIdEtiqueta(Long.parseLong(EtiquetaProduto));
			tarefaFilho.setIdNotaFiscal(controleEntradaColetor.getIdNotaFiscal());
			tarefaFilho.setIdProduto(controleEntradaColetor.getIdProduto());
			tarefaFilho.setLote(controleEntradaColetor.getLote());
			tarefaFilho.setQtdProduto(controleEntradaColetor.getQuantidade());
			tarefaFilho.setIdPosicaoDestino(idPosicao);
			tarefaFilho.setIdNivelDestino(idNivel);

			tarefaPosicionamentoRepository.save(tarefaFilho);

			if (nfRepository.getReferenceById(controleEntradaColetor.getIdNotaFiscal()).getIdTipoEntrada()
					.getId() == 2) {
				retencaoAutomatica(nfProdutoRepository, controleEntradaColetor);
			}

		}

	}

	//Metodo que faz a retenção Automatica
	public void retencaoAutomatica(NotaFiscalProdutoRepository nfProdutoRepository,
			ControleEntradaColetor controleEntradaColetor) {

		Optional<NotaFiscalProduto> nfProduto = nfProdutoRepository.findByIdNotaFiscal_IdAndIdProduto_IdAndLote(
				controleEntradaColetor.getIdNotaFiscal(), controleEntradaColetor.getIdProduto(),
				controleEntradaColetor.getLote());

		if (nfProduto.isPresent()) {
			NotaFiscalProduto produtoNota = nfProduto.get();
			produtoNota.setEstoqueRetido(produtoNota.getQuantidadeProduto());
			nfProdutoRepository.save(produtoNota);
		}

	}

}
