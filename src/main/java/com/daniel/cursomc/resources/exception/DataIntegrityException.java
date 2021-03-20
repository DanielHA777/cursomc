package com.daniel.cursomc.resources.exception;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.daniel.cursomc.services.ObjNotFoundException;

@ControllerAdvice
public class DataIntegrityException { // implementando classe auxiliar que vai interceptar as exceções
	@ExceptionHandler(ObjNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND, e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
