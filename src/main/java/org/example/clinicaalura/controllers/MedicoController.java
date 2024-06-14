package org.example.clinicaalura.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.clinicaalura.dto.medico.ActualizarMedicoDTO;
import org.example.clinicaalura.dto.medico.CrearMedicoDTO;
import org.example.clinicaalura.dto.medico.MedicoDTO;
import org.example.clinicaalura.services.specifications.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medico")
@AllArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping("/save")
    public ResponseEntity<MedicoDTO> saveMedico(@RequestBody @Valid CrearMedicoDTO medicoDTO,
                                UriComponentsBuilder uriComponentsBuilder) {
        MedicoDTO response = medicoService.saveMedico(medicoDTO);
        URI uri = uriComponentsBuilder.path("/medico/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<MedicoDTO>> listMedicos(@PageableDefault(size = 2) Pageable pageable) {
        return ResponseEntity.ok(medicoService.listMedicos(pageable));
    }

    @PutMapping("/update")
    public ResponseEntity<Long> updateMedico(@RequestBody ActualizarMedicoDTO medicoDTO) {
        return ResponseEntity.ok(medicoService.updateMedico(medicoDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMedico(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.deleteMedico(id));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MedicoDTO> findMedico(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.findById(id));
    }
}
