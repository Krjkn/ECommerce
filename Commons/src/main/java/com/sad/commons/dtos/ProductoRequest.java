package com.sad.commons.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductoRequest(
        @NotBlank(message = "El nombre no puede ser nulo o vacío")
        @Size(min = 20, max = 30, message = "El nombre debe tener entre 20 y 30 caracteres")
        String nombre,
        @NotBlank(message = "La descripción no puede ser nula o vacía")
        @Size(min = 20, max = 150, message = "La descripción debe tener entre 20 y 150 caracteres")
        String descripcion,
        @NotNull(message = "El precio no puede ser nulo")
        @Min(value = 0, message = "El precio no puede ser negativo")
        Double precio,
        @NotNull(message = "El stock no puede ser nulo")
        @Min(value = 0, message = "El stock no puede ser negativo")
        Short stock
        
        
) {
}