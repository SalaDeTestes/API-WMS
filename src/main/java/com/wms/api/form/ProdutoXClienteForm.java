package com.wms.api.form;

import com.wms.api.models.ProdutoXCliente;
import com.wms.api.repository.ClienteRepository;
import com.wms.api.repository.ProdutoRepository;
import com.wms.api.repository.ProdutoXClienteRepository;

public class ProdutoXClienteForm {

	private Long idProduto;
	private Long idCliente;
	private Long idCategoria;
	
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public ProdutoXCliente formulario(ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
		
		ProdutoXCliente produtoCliente = new ProdutoXCliente();
		
		produtoCliente.setIdCategoria(idCategoria);
		produtoCliente.setIdCliente(clienteRepository.getReferenceById(idCliente));
		produtoCliente.setIdProduto(produtoRepository.getReferenceById(idProduto));
		
		return produtoCliente;
		
	}
	
public ProdutoXCliente atualizar(Long id, ProdutoXClienteRepository produtoClienteRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
		
		ProdutoXCliente produtoCliente = produtoClienteRepository.getReferenceById(id);
		
		produtoCliente.setIdCategoria(idCategoria);
		produtoCliente.setIdCliente(clienteRepository.getReferenceById(idCliente));
		produtoCliente.setIdProduto(produtoRepository.getReferenceById(idProduto));
		
		return produtoCliente;
		
	}
}
