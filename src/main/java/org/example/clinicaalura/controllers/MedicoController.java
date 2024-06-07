package org.example.clinicaalura.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.clinicaalura.dto.medico.CrearMedicoDTO;
import org.example.clinicaalura.services.specifications.MedicoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
@AllArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping("/save")
    public Long saveMedico( @Validated @RequestBody CrearMedicoDTO medicoDTO) {
        return medicoService.saveMedico(medicoDTO);
    }
}
