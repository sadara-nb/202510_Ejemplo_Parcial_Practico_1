package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.EspecialidadRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EspecialidadService {
    
	@Autowired
	EspecialidadRepository especialidadRepository;

	@Transactional
    public EspecialidadEntity CreateEspecialidad(EspecialidadEntity especialidad) {
        log.info("Inicia proceso de creación de una nueva especialidad");
        if(especialidad.getDescripcion().length() > 10) {
            return especialidadRepository.save(especialidad);
        }
        else {
            throw new IllegalArgumentException("El id del médico debe empezar con RM");
        }
    }

}
