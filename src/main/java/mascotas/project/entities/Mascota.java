package mascotas.project.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "companiero", schema = "public")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companiero_id_seq")
    @SequenceGenerator(name = "companiero_id_seq", sequenceName = "companiero_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private String raza;

    @Column(nullable = false, length = 1)
    private String sexo;

    @Column(nullable = true)
    private String color;

    @Column(name = "descripicon", length = 255)
    private String descripcion;

    @Column(name = "f_naciemiento", nullable = true)
    private LocalDate fNacimiento;

    @Column(nullable = true)
    private Boolean esterilizado;

    @Column(nullable = true)
    private Boolean chipeado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "familiar", nullable = false)
    private Usuario familiar;

}