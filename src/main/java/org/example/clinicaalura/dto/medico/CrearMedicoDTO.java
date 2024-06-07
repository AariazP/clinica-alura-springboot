package org.example.clinicaalura.dto.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.example.clinicaalura.domain.Especialidad;
import org.example.clinicaalura.domain.Medico;
import org.example.clinicaalura.dto.direccion.DireccionDTO;

public record CrearMedicoDTO(
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "El nombre solo puede contener letras")
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{6}", message = "El documento solo puede contener números y tener 6 caracteres")
        String documento,
        @NotNull
        Especialidad especialidad,
        @NotNull
        @Valid
        DireccionDTO direccion
) {
    public Medico toEntity() {
        return new Medico(null, nombre, email, documento, especialidad, direccion.toEntity(), true);
    }
}
