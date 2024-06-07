package org.example.clinicaalura.dto.direccion;

import org.example.clinicaalura.domain.Direccion;

public record DireccionDTO(
        String calle,

        String numero,

        String complemento,

        String distrito,

        String ciudad
) {


    public Direccion toEntity() {
        return new Direccion(calle, numero, complemento, distrito, ciudad);
    }
}
