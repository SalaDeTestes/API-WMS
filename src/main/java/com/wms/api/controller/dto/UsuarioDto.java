package com.wms.api.controller.dto;

import com.wms.api.models.Usuario;

public class UsuarioDto {

	private Long id;
	private String login;
	private String nome;
	private String senha;
	private String cpf;
	private String celular;
	private String email;
	private Boolean status;
	private Long idEmpresa;
	private Long idPerfil;

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.login = usuario.getLogin();
		this.nome = usuario.getNome();
		this.senha = usuario.getSenha();
		this.cpf = usuario.getCpf();
		this.celular = usuario.getCelular();
		this.email = usuario.getEmail();
		this.status = usuario.getStatus();
		this.idEmpresa = usuario.getIdEmpresa();
		this.idPerfil = usuario.getIdPerfil();
	}

	public String getLogin() {
		return login;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCelular() {
		return celular;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getStatus() {
		return status;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public Long getId() {
		return id;
	}

}
