package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbMercadoriaClienteCategoria")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ProdutoXCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_MercadoriaClienteCategoria")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_Id_Mercadoria")
	private Produto idProduto;

	@ManyToOne
	@JoinColumn(name = "fk_Id_Cliente")
	private Cliente idCliente;

	@ManyToOne
	@JoinColumn(name = "fk_Id_Categoria")
	private CategoriaProduto idCategoria;

	public ProdutoXCliente() {

	}

	public ProdutoXCliente(Cliente idCliente, Produto idProduto, CategoriaProduto idCategoria) {
		this.idCliente = idCliente;
		this.idProduto = idProduto;
		this.idCategoria = idCategoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public CategoriaProduto getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(CategoriaProduto idCategoria) {
		this.idCategoria = idCategoria;
	}

}
