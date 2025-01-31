package mascotas.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ExtravioDTO {

    private Long creador;
    private Long idMascota;
    private String zona;
    private LocalDate hora;

    /*private LocalDate tiempoGracia;
    private Boolean atencionMedica;*/
}
