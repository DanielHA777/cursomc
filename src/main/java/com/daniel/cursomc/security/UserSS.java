package com.daniel.cursomc.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.daniel.cursomc.domain.Perfil;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

public class UserSS implements UserDetails { // implementa esse contrato
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String senha;
	private java.util.Collection<? extends GrantedAuthority> authorities;
	
	public UserSS() {
		
	}
	
	public UserSS(Integer id, String email, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList()); //para cada perfil x pegue a dewcrição  gere a lista 
	}

	public Integer getId() {
		return id;
	}
	
	@Override
	public java.util.Collection<? extends GrantedAuthority> getAuthorities() {
		return getAuthorities();
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() { // conta n expirada, pode se incluir regra de expiração de conta
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // conta n bloqueada
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // credenciais n expiradas
		return true;
	}

	@Override
	public boolean isEnabled() { // usuário ativo
		return true;
	}
	
	public boolean hasRole(Perfil perfil) {
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));//pertence a lista de authorities para ver perfil
	}
}