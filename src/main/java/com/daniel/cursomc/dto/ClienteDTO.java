package com.daniel.cursomc.dto;

import java.io.Serializable;

import com.daniel.cursomc.domain.Cliente;

public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
    private Integer id; 
   //@NotEmpty(message="prenchimento obrigatorio")
    //@lenght (min=5, max=30, message"0 tamanho errado")
    private String nome;
   
    private String email;
    
    public ClienteDTO() {
    	
    }
    
    public ClienteDTO(Cliente obj) {
    	id = obj.getId();
    			nome = obj.getNome();
    	email = obj.getEmail();
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
