package mascotas.project.services;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mascotas.project.dto.MascotaDTODetalle;
import mascotas.project.dto.MascotaDTORequest;
import mascotas.project.dto.MascotaDTOSaveSucces;
import mascotas.project.entities.Mascota;
import mascotas.project.mapper.MascotaMapper;
import mascotas.project.repositories.MascotaRepository;
import mascotas.project.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class MascotaService {

    @Autowired
    MascotaRepository mascotaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    MascotaMapper mascotaMapper;


    @Transactional
    public MascotaDTOSaveSucces saveMascota(MascotaDTORequest mascotaDTORequest) throws ChangeSetPersister.NotFoundException {

        usuarioRepository.findById(mascotaDTORequest.getFamiliarId())
                         .orElseThrow(() -> new ChangeSetPersister.NotFoundException()); //TODO: implementar las excepciones

        Mascota mascota = mascotaMapper.INSTANCE.toEntity(mascotaDTORequest);
        mascota = mascotaRepository.save(mascota);

        //retorno la mascota persistida
        return MascotaDTOSaveSucces.builder()
                                   .id(mascota.getId())
                                   .nombre(mascota.getNombre())
                                   .familiarId(mascota.getFamiliar().getId())
                                   .build();
    }

    @Transactional
    public MascotaDTODetalle getMascotaById(Long id) throws ChangeSetPersister.NotFoundException {

        Mascota mascota = mascotaRepository.findById(id)
                                           .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        return MascotaMapper.INSTANCE.toDTO(mascota);
    }


    public List<MascotaDTODetalle> getMascotasByFamiliarId(Long usuarioId) throws ChangeSetPersister.NotFoundException {

        usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        return mascotaRepository.findByFamiliarId(usuarioId)
                .stream()
                .map(mascotaMapper::toDTO)
                .toList();
    }



}
