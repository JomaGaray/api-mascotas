package mascotas.project.mapper;

import mascotas.project.dto.ExtravioDTO;
import mascotas.project.entities.Extravio;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper(componentModel = "spring")
public interface ExtravioMapper {



    Extravio toEntity(ExtravioDTO dto);
}
