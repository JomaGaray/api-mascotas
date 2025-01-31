package mascotas.project.mapper;

import mascotas.project.dto.PostulacionDTO;
import mascotas.project.entities.Postulacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostulacionMapper {

    @Mapping(target="usuario", source="postulacion.usuario.id")
    @Mapping(target="adopcion", source="postulacion.adopcion.id")
    @Mapping(target="fecha", source="postulacion.fecha")
    PostulacionDTO toPostulacionDTO(Postulacion postulacion);
}
