package com.wms.api.form;

import com.wms.api.models.Transportadora;
import com.wms.api.repository.TransportadoraRepository;

public class TransportadoraForm {


	private String razaoSocial;
	private String cnpj;
	private String cpf;
	private String cep;
	private String cidade;
	private String telefone;
	private String email;
	private String responsavel;
	
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
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
	
	public Transportadora formulario() {
		Transportadora transportadora = new Transportadora();
		
		transportadora.setRazaoSocial(razaoSocial);
		transportadora.setCnpj(cnpj);
		transportadora.setCpf(cpf);
		transportadora.setCep(cep);
		transportadora.setCidade(cidade);
		transportadora.setTelefone(telefone);
		transportadora.setEmail(email);
		transportadora.setResponsavel(responsavel);
		
		return transportadora;
	}
	
	public Transportadora atualizar(Integer id, TransportadoraRepository transportadoraRepository) {
		Transportadora transportadora = transportadoraRepository.getReferenceById(id);
		
		transportadora.setRazaoSocial(razaoSocial);
		transportadora.setCnpj(cnpj);
		transportadora.setCpf(cpf);
		transportadora.setCep(cep);
		transportadora.setCidade(cidade);
		transportadora.setTelefone(telefone);
		transportadora.setEmail(email);
		transportadora.setResponsavel(responsavel);
		
		return transportadora;
	}
	
	
}
