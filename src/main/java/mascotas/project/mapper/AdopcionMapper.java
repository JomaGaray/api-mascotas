package mascotas.project.mapper;

import mascotas.project.dto.AdopcionDTO;
import mascotas.project.entities.Adopcion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdopcionMapper {

    @Mapping(target="mascota.id", source="adopcionDTO.mascotaId")
    @Mapping(target="administrador.id", source="adopcionDTO.administradorId")
    Adopcion toEntity (AdopcionDTO adopcionDTO);


    @Mapping(target="mascotaId", source="mascota.id")
    @Mapping(target="administradorId", source="administrador.id")
    AdopcionDTO toDto (Adopcion adopcionEntity);
}
