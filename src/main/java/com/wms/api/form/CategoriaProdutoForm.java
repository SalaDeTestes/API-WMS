package com.wms.api.form;

import com.wms.api.models.CategoriaProduto;
import com.wms.api.repository.CategoriaProdutoRepository;

public class CategoriaProdutoForm {

	private String descricaoCategoria;

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public CategoriaProduto formulario() {

		CategoriaProduto categoriaProduto = new CategoriaProduto();

		categoriaProduto.setDescricaoCategoria(descricaoCategoria);

		return categoriaProduto;
	}

	public CategoriaProduto atualizar(Long id, CategoriaProdutoRepository categoriaProdutoRepository) {

		CategoriaProduto categoriaProduto = categoriaProdutoRepository.getReferenceById(id);

		categoriaProduto.setDescricaoCategoria(descricaoCategoria);

		return categoriaProduto;
	}
}
