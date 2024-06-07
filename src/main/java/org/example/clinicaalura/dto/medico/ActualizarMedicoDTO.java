package org.example.clinicaalura.dto.medico;

import org.example.clinicaalura.dto.direccion.DireccionDTO;

public record ActualizarMedicoDTO(
        Long id,
        String nombre,
        String documento,
        DireccionDTO direccion
) {
}
