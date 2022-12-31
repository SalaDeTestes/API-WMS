package com.wms.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbUsuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_Id_Usuario")
	private Long id;
	
	@Column(name = "Ds_Login")
	private String login;
	
	@Column(name = "Nm_Usuario")
	private String nome;
	
	@Column(name = "Ds_Senha")
	private String senha;
	
	@Column(name = "Nr_CPF")
	private String cpf;
	
	@Column(name = "Ds_Celular")
	private String celular;
	
	@Column(name = "Ds_Email")
	private String email;
	
	@Column(name = "Status")
	private Boolean status;
	
	@Column(name = "fk_Id_Empresa")
	private Long idEmpresa;
	
	@Column(name = "fk_Id_Perfil")
	private Long idPerfil;
	
	
	public Usuario() {
		
	}
	
	public Usuario(String login, String nome, String email, String senha, String cpf, String celular, Boolean status, Long idPerfil, Long idEmpresa) {
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.senha = senha; 
		this.cpf = cpf;
		this.celular = celular;
		this.status = status;
		this.idPerfil = idPerfil;
		this.idEmpresa = idEmpresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	
		     

}
