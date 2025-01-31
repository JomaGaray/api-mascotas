package mascotas.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Extravio")
public class Extravio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adopcion_id_seq")
    @SequenceGenerator(name = "adopcion_id_seq", sequenceName = "adopcion_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creador_id")
    private Usuario creador;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    private String zona;

    private LocalDate hora;

    private LocalDate tiempo_gracia;

    private Boolean atencion_medica;

}
