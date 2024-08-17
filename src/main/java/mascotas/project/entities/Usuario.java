package mascotas.project.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "USUARIO")
public class Usuario {

    private Long id;
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANIERO_ID")
    @ToString.Exclude
    private List<Companiero> companieros;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

}