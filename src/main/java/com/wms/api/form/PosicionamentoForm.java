package com.wms.api.form;

public class PosicionamentoForm {

	private String etiquetaProduto;
	private String etiquetaPosicionamento;

	public PosicionamentoForm() {

	}

	public PosicionamentoForm(String etiquetaProduto, String etiquetaPosicionamento) {

		this.etiquetaProduto = etiquetaProduto;
		this.etiquetaPosicionamento = etiquetaPosicionamento;
	}

	public String getEtiquetaProduto() {
		return etiquetaProduto;
	}

	public void setEtiquetaProduto(String etiquetaProduto) {
		this.etiquetaProduto = etiquetaProduto;
	}

	public String getEtiquetaPosicionamento() {
		return etiquetaPosicionamento;
	}

	public void setEtiquetaPosicionamento(String etiquetaPosicionamento) {
		this.etiquetaPosicionamento = etiquetaPosicionamento;
	}

	public PosicionamentoForm formulario() {

		PosicionamentoForm posiconamentoForm = new PosicionamentoForm();
		posiconamentoForm.setEtiquetaPosicionamento(etiquetaPosicionamento);
		posiconamentoForm.setEtiquetaProduto(etiquetaProduto);

		return posiconamentoForm;
	}

}
