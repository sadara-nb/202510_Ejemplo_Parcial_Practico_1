package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;


@Data
@Entity
public class MedicoEntity {
    Long id;
    String nombre;
    String apellido;
    String registro;

    

    @PodamExclude
    @ManyToMany
    private List<EspecialidadEntity> especialidades = new ArrayList<>();
}

