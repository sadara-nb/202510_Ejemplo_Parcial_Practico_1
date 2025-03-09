package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.EspecialidadRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import java.util.Optional;

@Slf4j
@Service
public class MedicoEspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public EspecialidadEntity addEspecialidad(Long idMedico, Long idEspecialidad) {
        log.info("Inicia proceso de agregar una especialidad a un médico");
        Optional<MedicoEntity> medicoEntity = medicoRepository.findById(idMedico);
        Optional<EspecialidadEntity> especialidadEntity = especialidadRepository.findById(idEspecialidad);
        
        if (medicoEntity.isEmpty())
            throw new IllegalArgumentException("El médico no existe");

        if (especialidadEntity.isEmpty())    
            throw new IllegalArgumentException("La especialidad no existe");
        
        especialidadEntity.get().getMedicos().add(medicoEntity.get());
        log.info("Termina proceso de asociar un una especialidad el médico con id = {0}", idMedico);
        return especialidadEntity.get();
    }

}
