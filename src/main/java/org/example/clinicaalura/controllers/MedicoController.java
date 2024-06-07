package org.example.clinicaalura.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.clinicaalura.dto.medico.CrearMedicoDTO;
import org.example.clinicaalura.services.specifications.MedicoService;
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
    public Long saveMedico(@RequestBody @Valid CrearMedicoDTO medicoDTO) {
        return medicoService.saveMedico(medicoDTO);
    }
}
