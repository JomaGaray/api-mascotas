package mascotas.project.repositories;

import mascotas.project.entities.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulacionRepository extends JpaRepository<Postulacion, Long> {
}
