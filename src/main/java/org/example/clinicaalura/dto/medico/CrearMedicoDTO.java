package org.example.clinicaalura.dto.medico;

import org.example.clinicaalura.domain.Especialidad;
import org.example.clinicaalura.domain.Medico;
import org.example.clinicaalura.dto.direccion.DireccionDTO;

public record CrearMedicoDTO(
        String nombre,

        String email,


        String documento,

        Especialidad especialidad,

        DireccionDTO direccion
) {
    public Medico toEntity() {
        return new Medico(null, nombre, email, documento, especialidad, direccion.toEntity());
    }
}
