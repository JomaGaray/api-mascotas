package mascotas.project.dto;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MascotaDTORequest {

    private Long id;
    private Long familiarId;
    private String nombre;
    private String especie;
    private String raza;
    private String sexo;
    private String color;
    private String descripcion;
    private LocalDate fNacimiento;
    private Boolean esterilizado;
    private Boolean chipeado;

}
