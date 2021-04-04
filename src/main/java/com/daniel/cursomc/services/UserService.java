package com.daniel.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.daniel.cursomc.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {//usuario authenticado ou logado
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();//retorna usuário logado
		}
		catch (Exception e) {
			return null;
		}
	}
}