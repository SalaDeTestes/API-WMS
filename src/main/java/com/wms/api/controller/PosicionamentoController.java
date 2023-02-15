package com.wms.api.controller;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.wms.api.repository.EtiquetaRepository;
import com.wms.api.repository.GalpaoLayoutRepository;
import com.wms.api.services.PosicionamentoService;

@RestController
@RequestMapping("/posicionar")
public class PosicionamentoController {
	
	@Autowired
	private GalpaoLayoutRepository galpaoLayoutRepository; 
	
	@Autowired
	private EtiquetaRepository etiquetaRepository; 
	
	@GetMapping
	@Transactional
	public void teste() {
		Boolean teste = PosicionamentoService.validaExistePosicao(galpaoLayoutRepository,  "010030201");
	}

}
