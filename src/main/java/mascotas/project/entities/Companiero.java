package mascotas.project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "COMPANIERO")
public class Companiero {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Companiero_id_seq", sequenceName = "Companiero_id_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @JoinColumn(name = "FAMILIAR_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario familiar;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fNaciemiento;

    private String nombre;
    private String especie;
    private String raza;
    private String sexo;
    private String color;
    private String descripcion;
    private Boolean esterilizado;
    private Boolean chipeado;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

}