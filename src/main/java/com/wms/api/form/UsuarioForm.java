package com.wms.api.form;

import com.wms.api.models.Usuario;
import com.wms.api.repository.UsuarioRepository;

public class UsuarioForm {

	
	private String login;
	private String nome;
	private String senha;
	private String cpf;
	private String celular;
	private String email;
	private Boolean status;
	private Long idEmpresa;
	private Long idPerfil;
	
	
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
	
	public Usuario formulario() {
		Usuario usuario = new Usuario();
		
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setCpf(cpf);
		usuario.setCelular(celular);
		usuario.setEmail(email);
		usuario.setStatus(status);
		usuario.setIdEmpresa(idEmpresa);
		usuario.setIdPerfil(idPerfil);
		
		return usuario;
	}
	
	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getReferenceById(id);
		
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setCpf(cpf);
		usuario.setCelular(celular);
		usuario.setEmail(email);
		usuario.setStatus(status);
		usuario.setIdEmpresa(idEmpresa);
		usuario.setIdPerfil(idPerfil);
		
		return usuario;
	}
	
}
