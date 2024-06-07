package org.example.clinicaalura.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Direccion {

    private String calle;

    private String numero;

    private String complemento;

    private String distrito;

    private String ciudad;
}
