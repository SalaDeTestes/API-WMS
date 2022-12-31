package com.wms.api.form;

import com.wms.api.models.Motorista;
import com.wms.api.repository.MotoristaRepository;
import com.wms.api.repository.TransportadoraRepository;

public class MotoristaForm {

	private Integer idTransportadora;
	private String nome;
	private String cpf;
	private String celular;
	public Integer getIdTransportadora() {
		return idTransportadora;
	}
	public void setIdTransportadora(Integer idTransportadora) {
		this.idTransportadora = idTransportadora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public Motorista formulario(TransportadoraRepository transportadoraRepository) {
		
		Motorista motorista = new Motorista();
		
		motorista.setIdTransportadora(transportadoraRepository.getReferenceById(idTransportadora));
		motorista.setNome(nome);
		motorista.setCelular(celular);
		motorista.setCpf(cpf);
		
		
		return motorista;
	}
	
public Motorista atualizar(Long id, TransportadoraRepository transportadoraRepository, MotoristaRepository motoristaRepository) {
		
		Motorista motorista = motoristaRepository.getReferenceById(id);
		
		motorista.setIdTransportadora(transportadoraRepository.getReferenceById(idTransportadora));
		motorista.setNome(nome);
		motorista.setCelular(celular);
		motorista.setCpf(cpf);
		
		
		return motorista;
	}
	
	
}
