package mascotas.project.services;

import lombok.extern.slf4j.Slf4j;
import mascotas.project.dto.AdopcionDTO;
import mascotas.project.entities.Adopcion;
import mascotas.project.mapper.AdopcionMapper;
import mascotas.project.repositories.AdopocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdopcionService {

    @Autowired
    AdopocionRepository adopcionRepository;

    @Autowired
    AdopcionMapper adopcionMapper;

    public Adopcion saveAdopcion(AdopcionDTO adopcionDtoRequest) {

            Adopcion adopcion = adopcionMapper.toEntity(adopcionDtoRequest);

            return adopcionRepository.save(adopcion);
    }


    public List<Adopcion> findAll() {
        return adopcionRepository.findAll();
    }




}
