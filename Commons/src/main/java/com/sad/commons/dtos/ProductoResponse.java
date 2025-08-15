package com.sad.commons.dtos;

public record ProductoResponse(
		Long id, 
		String nombre, 
		String descripcion,
		Double precio, 
		Short stock
		) {

}
