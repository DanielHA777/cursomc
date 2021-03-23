package com.daniel.cursomc.resources.exception;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.daniel.cursomc.services.ObjNotFoundException;

@ControllerAdvice
public class DataIntegrityException extends RuntimeException{
	private static final long serialVersionUID = 1L; // implementando classe auxiliar que vai interceptar as exceções
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
