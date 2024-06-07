package org.example.clinicaalura.dto.direccion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.example.clinicaalura.domain.Direccion;

public record DireccionDTO(
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z\\s]+\\d+$", message = "La calle solo puede contener letras")
        String calle,
        @NotBlank
        @Pattern(regexp = "\\d{1,4}", message = "El número solo puede contener números y tener entre 1 y 4 caracteres")
        String numero,
        @NotBlank
        String complemento,
        @NotBlank
        String distrito,
        @NotBlank
        String ciudad
) {


    public Direccion toEntity() {
        return new Direccion(calle, numero, complemento, distrito, ciudad);
    }
}
