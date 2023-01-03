package com.wms.api.form;

import java.time.LocalDateTime;

import com.wms.api.models.Cliente;
import com.wms.api.repository.ClienteRepository;

public class ClienteForm {

	private String descricaoRazaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	private String descricaoEndereco;
	private String numeroEndereco;
	private String cep;
	private String telefone;
	private String email;
	private String responsavel;
	private String cargoResponsavel;
	private String nomeFantasia;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizacao;
	private Boolean situacao;

	public String getDescricaoRazaoSocial() {
		return descricaoRazaoSocial;
	}

	public void setDescricaoRazaoSocial(String descricaoRazaoSocial) {
		this.descricaoRazaoSocial = descricaoRazaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getDescricaoEndereco() {
		return descricaoEndereco;
	}

	public void setDescricaoEndereco(String descricaoEndereco) {
		this.descricaoEndereco = descricaoEndereco;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getCargoResponsavel() {
		return cargoResponsavel;
	}

	public void setCargoResponsavel(String cargoResponsavel) {
		this.cargoResponsavel = cargoResponsavel;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public Cliente formulario() {
		Cliente cliente = new Cliente();

		cliente.setDescricaoRazaoSocial(descricaoRazaoSocial);
		cliente.setCnpj(cnpj);
		cliente.setInscricaoEstadual(inscricaoEstadual);
		cliente.setDescricaoEndereco(descricaoEndereco);
		cliente.setNumeroEndereco(numeroEndereco);
		cliente.setCep(cep);
		cliente.setTelefone(telefone);
		cliente.setEmail(email);
		cliente.setResponsavel(responsavel);
		cliente.setCargoResponsavel(cargoResponsavel);
		cliente.setNomeFantasia(nomeFantasia);
		cliente.setDataCadastro(dataCadastro);
		cliente.setDataAtualizacao(dataAtualizacao);
		cliente.setSituacao(situacao);

		return cliente;
	}

	public Cliente atualizar(Long id, ClienteRepository clienteRepository) {

		Cliente cliente = clienteRepository.getReferenceById(id);

		cliente.setDescricaoRazaoSocial(descricaoRazaoSocial);
		cliente.setCnpj(cnpj);
		cliente.setInscricaoEstadual(inscricaoEstadual);
		cliente.setDescricaoEndereco(descricaoEndereco);
		cliente.setNumeroEndereco(numeroEndereco);
		cliente.setCep(cep);
		cliente.setTelefone(telefone);
		cliente.setEmail(email);
		cliente.setResponsavel(responsavel);
		cliente.setCargoResponsavel(cargoResponsavel);
		cliente.setNomeFantasia(nomeFantasia);
		cliente.setDataCadastro(dataCadastro);
		cliente.setDataAtualizacao(dataAtualizacao);
		cliente.setSituacao(situacao);

		return cliente;
	}

}
