package com.wms.api.services;

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
import com.wms.api.repository.NotaFiscalProdutoRepository;
import com.wms.api.repository.NotaFiscalRepository;

@CacheEvict(value = "controleRecebimentoRepository", allEntries = true)
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
			NotaFiscalRepository nfRepository, DocaRepository docaRepository) {
		
//		Doca doca = docaRepository.getReferenceById(controleRecebimento.getIdDoca());
//		doca.setOcupada(false);
//		doca.setNumeroCarga("0");
//		doca.setRecebimento(false);

		NotaFiscal nf = nfRepository.findByNumeroCarga(controleRecebimento.getNumeroCarga());
		nf.setEntradaValidada(true);

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
			ControleEntradaProdutoPorPosicaoRepository controleEntradaProdutoPorPosicaoRepository, NotaFiscalProdutoRepository nfprodutoRepository) {

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
			
			NotaFiscalProduto nfproduto = nfprodutoRepository.findByIdNotaFiscal_idAndIdProduto_id(listControleEntradaProdutoConferencia.getIdNotaFiscal(), listControleEntradaProdutoConferencia.getIdProduto());
			nfproduto.setLote(listControleEntradaProdutoConferencia.getLote());
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
			NotaFiscalRepository nfRepository, NotaFiscalProdutoRepository nfprodutoRepository, DocaRepository docaRepository) {
		salvarRecebimentoProdutoQuantidadeParcial(controleRecebimento, controleRecebimentoRepository,
				entradaColetorRepository, controleEntradaProdutoPorPosicaoRepository, controleEntradaEtiquetaRepository,
				controleEntradaProdutoConferenciaRepository, controleEntradaProdutoEtiquetaRepository,
				controleConferenciaRepository, controleEntradaColetorStatusRepository, nfRepository, docaRepository);
		salvarRecebimentoTotal(controleRecebimento, controleEntradaProdutoConferenciaRepository, nfRepository,
				controleEntradaProdutoPorPosicaoRepository, nfprodutoRepository);
	}

}
