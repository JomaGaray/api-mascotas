package mascotas.project.dto;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MascotaDTOSaveSucces {

    private Long id;
    private String nombre;
    private Long familiarId;

}
