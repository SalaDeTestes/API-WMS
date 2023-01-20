package com.wms.api.controller.dto;

import com.wms.api.models.Cliente;
import com.wms.api.models.Produto;
import com.wms.api.models.ProdutoXCliente;

public class ProdutoXClienteDto {

	private Long id;
	private Cliente idCliente;
	private Produto idProduto;
	private Long idCategoria;

	public ProdutoXClienteDto(ProdutoXCliente produtoCliente) {
		this.id = produtoCliente.getId();
		this.idCliente = produtoCliente.getIdCliente();
		this.idProduto = produtoCliente.getIdProduto();
		this.idCategoria = produtoCliente.getIdCategoria();
	}

	public Long getId() {
		return id;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public Produto getIdProduto() {
		return idProduto;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

}
