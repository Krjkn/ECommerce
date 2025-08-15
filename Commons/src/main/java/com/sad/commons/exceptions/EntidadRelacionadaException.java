package com.sad.commons.exceptions;

public class EntidadRelacionadaException extends IllegalStateException {
	public static final long serialVersionUID=1L;
	
	public EntidadRelacionadaException(String mensaje) {
		super(mensaje);
	}
}