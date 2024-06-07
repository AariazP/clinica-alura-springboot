package org.example.clinicaalura.services.implement;

import lombok.AllArgsConstructor;
import org.example.clinicaalura.domain.Medico;
import org.example.clinicaalura.dto.medico.ActualizarMedicoDTO;
import org.example.clinicaalura.dto.medico.CrearMedicoDTO;
import org.example.clinicaalura.dto.medico.MedicoDTO;
import org.example.clinicaalura.repositories.MedicoRepository;
import org.example.clinicaalura.services.specifications.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@AllArgsConstructor
public class MedicoServicesImpl implements MedicoService {

    private final MedicoRepository medicoRepository;

    public Long saveMedico( CrearMedicoDTO medicoDTO) {
        return medicoRepository.save(medicoDTO.toEntity()).getId();
    }

    @Override
    public Page<MedicoDTO> listMedicos(Pageable pageable) {
       return medicoRepository.findAll(pageable).map(MedicoDTO::fromEntity);
    }

    @Override
    public Long updateMedico(ActualizarMedicoDTO medicoDTO) {
        Medico medico = medicoRepository.findById(medicoDTO.id()).orElseThrow();

        if(medicoDTO.nombre() != null) medico.setNombre(medicoDTO.nombre());
        if(medicoDTO.documento() != null) medico.setDocumento(medicoDTO.documento());
        if(medicoDTO.direccion() != null) medico.setDireccion(medicoDTO.direccion().toEntity());

        return medicoRepository.save(medico).getId();

    }
}
