package com.sad.commons.dtos;

import java.sql.Date;
import java.util.Set;

public record PedidoResponse(
		Long id, 
		Long idCliente,
		Set<String> listaProductos,
		Double total,
		Date fechaDeCreacion,
		String estado
		){

}
