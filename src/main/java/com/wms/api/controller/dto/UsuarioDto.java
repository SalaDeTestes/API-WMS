package com.wms.api.controller.dto;


import java.util.List;
import java.util.stream.Collectors;

import com.wms.api.models.Usuario;

public class UsuarioDto {

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
	
	public static List<UsuarioDto> converter(List<Usuario> usuario){
		
		return usuario.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
	
}
