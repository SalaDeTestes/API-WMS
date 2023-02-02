package com.wms.api.services;

import com.wms.api.models.ControleConferencia;
import com.wms.api.models.ControleEntradaColetor;
import com.wms.api.models.ControleEntradaColetorStatus;
import com.wms.api.models.ControleEntradaEtiqueta;
import com.wms.api.models.ControleEntradaProdutoConferencia;
import com.wms.api.models.ControleEntradaProdutoEtiqueta;
import com.wms.api.models.ControleEntradaProdutoPorPosicao;
import com.wms.api.models.ControleRecebimento;
import com.wms.api.repository.ControleConferenciaRepository;
import com.wms.api.repository.ControleEntradaColetorRepository;
import com.wms.api.repository.ControleEntradaColetorStatusRepository;
import com.wms.api.repository.ControleEntradaEtiquetaRepository;
import com.wms.api.repository.ControleEntradaProdutoConferenciaRepository;
import com.wms.api.repository.ControleEntradaProdutoEtiquetaRepository;
import com.wms.api.repository.ControleEntradaProdutoPorPosicaoRepository;
import com.wms.api.repository.ControleRecebimentoRepository;
import com.wms.api.repository.NotaFiscalRepository;

public class ControleRecebimentoService {

	public void salvarRecebimentoProdutoQuantidadeParcial(ControleRecebimento controleRecebimento,
			ControleRecebimentoRepository controleRecebimentoRepository,
			ControleEntradaColetorRepository entradaColetorRepository,
			ControleEntradaProdutoPorPosicaoRepository controleEntradaProdutoPorPosicaoRepository,
			ControleEntradaEtiquetaRepository controleEntradaEtiquetaRepository,
			ControleEntradaProdutoConferenciaRepository controleEntradaProdutoConferenciaRepository,
			ControleEntradaProdutoEtiquetaRepository controleEntradaProdutoEtiquetaRepository,
			ControleConferenciaRepository controleConferenciaRepository,
			ControleEntradaColetorStatusRepository controleEntradaColetorStatusRepository,
			NotaFiscalRepository nfRepository) {

		ControleConferencia controleConferencia = new ControleConferencia();
		controleConferencia.setIdDoca(controleRecebimento.getIdDoca());
		controleConferencia.setIdUsuario(controleRecebimento.getIdUsuario());
		controleConferencia.setNumeroCarga(controleRecebimento.getNumeroCarga());
		controleConferencia.setDataInicio(controleRecebimento.getDataInicio());
		controleConferenciaRepository.save(controleConferencia);

		for (ControleEntradaColetor listcontroleEntradaColetor : controleRecebimento.getControleEntradaColetor()) {

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

	}

	public void salvarRecebimentoTotal(ControleRecebimento controleRecebimento,
			ControleEntradaProdutoConferenciaRepository controleEntradaProdutoConferenciaRepository,
			NotaFiscalRepository nfRepository,
			ControleEntradaProdutoPorPosicaoRepository controleEntradaProdutoPorPosicaoRepository) {

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

	public void salvarRecebimento(ControleRecebimento controleRecebimento,
			ControleRecebimentoRepository controleRecebimentoRepository,
			ControleEntradaColetorRepository entradaColetorRepository,
			ControleEntradaProdutoPorPosicaoRepository controleEntradaProdutoPorPosicaoRepository,
			ControleEntradaEtiquetaRepository controleEntradaEtiquetaRepository,
			ControleEntradaProdutoConferenciaRepository controleEntradaProdutoConferenciaRepository,
			ControleEntradaProdutoEtiquetaRepository controleEntradaProdutoEtiquetaRepository,
			ControleConferenciaRepository controleConferenciaRepository,
			ControleEntradaColetorStatusRepository controleEntradaColetorStatusRepository,
			NotaFiscalRepository nfRepository) {
		salvarRecebimentoProdutoQuantidadeParcial(controleRecebimento, controleRecebimentoRepository,
				entradaColetorRepository, controleEntradaProdutoPorPosicaoRepository, controleEntradaEtiquetaRepository,
				controleEntradaProdutoConferenciaRepository, controleEntradaProdutoEtiquetaRepository,
				controleConferenciaRepository, controleEntradaColetorStatusRepository, nfRepository);
		salvarRecebimentoTotal(controleRecebimento, controleEntradaProdutoConferenciaRepository, nfRepository,
				controleEntradaProdutoPorPosicaoRepository);
	}

}
