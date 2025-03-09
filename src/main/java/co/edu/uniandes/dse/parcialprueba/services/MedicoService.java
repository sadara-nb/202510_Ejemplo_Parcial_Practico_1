package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoService {
    
	@Autowired
	MedicoRepository medicoRepository;

	@Transactional
    public MedicoEntity createMedico(MedicoEntity medico) {
        log.info("Inicia proceso de creación de un nuevo médico");
        if(medico.getRegistro().toString().startsWith("RM")) {
            return medicoRepository.save(medico);
        }
        else {
            throw new IllegalArgumentException("El id del médico debe empezar con RM");
        }
    }

}
