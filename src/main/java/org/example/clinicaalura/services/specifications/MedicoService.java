package org.example.clinicaalura.services.specifications;

import org.example.clinicaalura.dto.medico.ActualizarMedicoDTO;
import org.example.clinicaalura.dto.medico.CrearMedicoDTO;
import org.example.clinicaalura.dto.medico.MedicoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicoService {

    MedicoDTO saveMedico(CrearMedicoDTO medicoDTO);

    Page<MedicoDTO> listMedicos(Pageable pageable);

    Long updateMedico(ActualizarMedicoDTO medicoDTO);

    String deleteMedico(Long id);

    MedicoDTO findById(Long id);
}
