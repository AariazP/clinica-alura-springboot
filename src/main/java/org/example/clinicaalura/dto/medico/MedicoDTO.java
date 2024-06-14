package org.example.clinicaalura.dto.medico;

import org.example.clinicaalura.domain.Medico;

public record MedicoDTO(
        Long id,
        String nombre,
        String Especialidad,
        String documento,
        String email
) {

    public MedicoDTO(Medico medico){
        this(medico.getId(),medico.getNombre(), medico.getEspecialidad().name(), medico.getDocumento(), medico.getEmail());
    }

    public static MedicoDTO fromEntity(Medico medico) {
        return new MedicoDTO(medico.getId(),medico.getNombre(), medico.getEspecialidad().name(), medico.getDocumento(), medico.getEmail());
    }

}
