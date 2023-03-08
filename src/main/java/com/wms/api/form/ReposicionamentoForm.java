package com.wms.api.form;

public class ReposicionamentoForm {

	private String etiquetaProduto;
	private String etiquetaPosicionamentoOrigem;
	private String etiquetaPosicionamentoDestino;
	private Long idUsuario;

	public ReposicionamentoForm() {

	}

	public ReposicionamentoForm(String etiquetaProduto, String etiquetaPosicionamentoOrigem,
			String etiquetaPosicionamentoDestino, Long idUsuario) {

		this.etiquetaProduto = etiquetaProduto;
		this.etiquetaPosicionamentoOrigem = etiquetaPosicionamentoOrigem;
		this.etiquetaPosicionamentoDestino = etiquetaPosicionamentoDestino;
		this.idUsuario = idUsuario;
	}

	public String getEtiquetaPosicionamentoOrigem() {
		return etiquetaPosicionamentoOrigem;
	}

	public String getEtiquetaProduto() {
		return etiquetaProduto;
	}

	public void setEtiquetaProduto(String etiquetaProduto) {
		this.etiquetaProduto = etiquetaProduto;
	}

	public String Destino() {
		return etiquetaPosicionamentoOrigem;
	}

	public void setEtiquetaPosicionamentoOrigem(String etiquetaPosicionamentoOrigem) {
		this.etiquetaPosicionamentoOrigem = etiquetaPosicionamentoOrigem;
	}

	public String getEtiquetaPosicionamentoDestino() {
		return etiquetaPosicionamentoDestino;
	}

	public void setEtiquetaPosicionamentoDestino(String etiquetaPosicionamentoDestino) {
		this.etiquetaPosicionamentoDestino = etiquetaPosicionamentoDestino;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public ReposicionamentoForm formulario() {

		ReposicionamentoForm reposicionamentoForm = new ReposicionamentoForm();
		reposicionamentoForm.setEtiquetaPosicionamentoOrigem(etiquetaPosicionamentoOrigem);
		reposicionamentoForm.setEtiquetaPosicionamentoDestino(etiquetaPosicionamentoDestino);
		reposicionamentoForm.setEtiquetaProduto(etiquetaProduto);
		reposicionamentoForm.setIdUsuario(idUsuario);

		return reposicionamentoForm;
	}

}
