package com.sad.commons.controllers;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {
private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class.getName());
	

@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException e){
		LOGGER.log(Level.WARNING, "Violación de restricción: " +
				(e.getCause() != null ? e.getCause() : e.getMessage()));
		return ResponseEntity.badRequest().body(Map.of(
				"code", HttpStatus.BAD_REQUEST.value(), 
				"response" , "Violación de restricción: " + e.getMessage()));
	}

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
	LOGGER.log(Level.WARNING, "Argumento no válido: " +
			(e.getCause() != null ? e.getCause() : e.getMessage()));

	// Concatenamos todos los mensajes de error de validación
	String mensaje = e.getBindingResult().getFieldErrors().stream()
			.map(error -> error.getField() + ": " + error.getDefaultMessage())
			.findFirst()
			.orElse("Error de validacion en los datos enviados");
	
	return ResponseEntity.badRequest().body(Map.of(
			"code", HttpStatus.BAD_REQUEST.value(),
			"response", mensaje
	));
	
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<Map<String, Object>> handleNoSuchElementException(NoSuchElementException e) {
	LOGGER.log(Level.WARNING, "No se encontro informacion asociada con el identificador ingresado");

	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
			"code", HttpStatus.NOT_FOUND.value(),
			"response", "Elemento no encontrado: " + e.getMessage()
	));
}


@ExceptionHandler(Exception.class)

public ResponseEntity<Map<String, Object>> handleDataIntegrityViolationException(Exception e) {
	LOGGER.log(Level.WARNING, "Error interno del servidor: " +
			(e.getCause() != null ? e.getCause() : e.getMessage()));

	return ResponseEntity.badRequest().body(Map.of(
			"code", HttpStatus.INTERNAL_SERVER_ERROR.value(),
			"response", "Error interno del servidor: " + e.getMessage()
	));
}

        
}
