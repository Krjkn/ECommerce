package com.sad.commons.dtos;

import java.util.List;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record PedidoRequest(
        @NotNull(message = "El ID del cliente no puede ser nulo")
        Long idCliente,
        @NotNull(message = "La lista de productos no puede ser nula")
        @Size(min = 1, message = "Debe haber al menos un producto en el pedido")
        
        @NotNull(message = "El total es requerido")
        @DecimalMin(value = "0.0", inclusive = false, message = "El total debe de ser mayor a 0")
        Double total,
        List<@NotNull Long> listaProductos,
        @NotNull(message = "El ID del producto no puede ser nulo")
        Long idProducto,
        @NotNull(message = "La cantidad del producto no puede ser nula")
        @Min(value = 1, message = "La cantidad del producto debe ser al menos 1")
        Integer cantidad
    ) {
}