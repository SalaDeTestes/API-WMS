package com.wms.api.services;

import java.util.ArrayList;
import java.util.List;

import com.wms.api.models.Etiqueta;
import com.wms.api.repository.EtiquetaRepository;

public class EtiquetaService {

	public static List<Etiqueta> gerarEtiqueta(int quantidadeEtiqueta, EtiquetaRepository etiquetaRepository) {
		List<Etiqueta> listaEtiqueta = new ArrayList<>();

		
		for (int i = 1; i <= quantidadeEtiqueta; i++) {

			Etiqueta etiqueta = new Etiqueta();

			etiquetaRepository.save(etiqueta);
			Etiqueta update = etiquetaRepository.getReferenceById(etiqueta.getId());
			update.setDescricaoEtiqueta(String.format("%08d",etiqueta.getId()));
			listaEtiqueta.add(update);
		}

		return listaEtiqueta;

	}
}
