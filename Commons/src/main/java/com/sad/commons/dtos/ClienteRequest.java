package com.sad.commons.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClienteRequest(
        @NotBlank(message = "El nombre no puede ser nulo o vacío")
        String nombre,
        @NotBlank(message = "El apellido no puede ser nulo o vacío")
        String apellido,
        @NotNull(message = "El email no puede ser nulo")
        @Email(message = "El email debe tener un formato válido")
        String email,
        @NotNull(message = "El teléfono no puede ser nulo")
        @Pattern(regexp = "\\d{10}", message = "El teléfono debe contener exactamente 10 dígitos")
        String telefono,
        @Size(max = 100, message = "La dirección no debe superar los 100 caracteres")
        String direccion
) {
}