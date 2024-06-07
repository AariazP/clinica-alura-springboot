package org.example.clinicaalura.services.implement;

import lombok.AllArgsConstructor;
import org.example.clinicaalura.dto.medico.CrearMedicoDTO;
import org.example.clinicaalura.repositories.MedicoRepository;
import org.example.clinicaalura.services.specifications.MedicoService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicoServicesImpl implements MedicoService {

    private final MedicoRepository medicoRepository;

    public Long saveMedico( CrearMedicoDTO medicoDTO) {
        return medicoRepository.save(medicoDTO.toEntity()).getId();
    }
}
