package org.example.clinicaalura.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.clinicaalura.dto.medico.ActualizarMedicoDTO;
import org.example.clinicaalura.dto.medico.CrearMedicoDTO;
import org.example.clinicaalura.dto.medico.MedicoDTO;
import org.example.clinicaalura.services.specifications.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/medico")
@AllArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping("/save")
    public Long saveMedico(@RequestBody @Valid CrearMedicoDTO medicoDTO) {
        return medicoService.saveMedico(medicoDTO);
    }

    @GetMapping("/list")
    public Page<MedicoDTO> listMedicos(@PageableDefault(size = 2) Pageable pageable) {
        return medicoService.listMedicos(pageable);
    }

    @PutMapping("/update")
    public Long updateMedico(@RequestBody ActualizarMedicoDTO medicoDTO) {
        return medicoService.updateMedico(medicoDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMedico(@PathVariable Long id) {
        return medicoService.deleteMedico(id);
    }
}
