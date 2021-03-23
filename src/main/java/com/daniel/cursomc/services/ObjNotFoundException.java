package com.daniel.cursomc.services;

public class ObjNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}