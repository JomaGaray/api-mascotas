package mascotas.project.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mascotas.project.dto.ExtravioDTO;
import mascotas.project.mapper.ExtravioMapper;
import mascotas.project.repositories.ExtravioRepository;
import mascotas.project.repositories.MascotaRepository;
import mascotas.project.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ExtravioService {

    private UsuarioRepository usuarioRepository;
    private MascotaRepository mascotaRepository;
    private ExtravioMapper extravioMapper;
    private ExtravioRepository extravioRepository;

    @Transactional
    public void saveExtravio(ExtravioDTO extravioDto) {

        Optional.of(extravioDto)
                .map(
                    extravioDTO -> {

                            mascotaRepository.findById(extravioDTO.getIdMascota())
                                             .orElseThrow(
                                                    () -> new IllegalArgumentException("No se encontró la mascota con ID: " + extravioDto.getIdMascota())
                                             );

                            usuarioRepository.findById(extravioDto.getCreador())
                                             .orElseThrow(
                                                    () -> new IllegalArgumentException("No se encontró al usuario con ID: " + extravioDto.getCreador())
                                             );

                           return extravioMapper.toEntity(extravioDto);
                    }
                ).map(
                        extravioEntity -> {
                            log.info("SAVE_EXTRAVIO : publicador:{} ; nombre Mascota{}" , extravioEntity.getCreador().getNombre(), extravioEntity.getMascota().getNombre());
                            extravioRepository.save(extravioEntity);
                            return null;
                        }
                );
    }
}
