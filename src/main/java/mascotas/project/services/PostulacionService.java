package mascotas.project.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mascotas.project.dto.PostulacionDTO;
import mascotas.project.entities.Postulacion;
import mascotas.project.mapper.PostulacionMapper;
import mascotas.project.repositories.AdopocionRepository;
import mascotas.project.repositories.PostulacionRepository;
import mascotas.project.repositories.UsuarioRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class PostulacionService {

    private PostulacionRepository postulacionRepository;
    private UsuarioRepository usuarioRepository;
    private AdopocionRepository adopcionRepository;
    private PostulacionMapper postulacionMapper;


    public PostulacionDTO savePostulacion(PostulacionDTO postulacion){

        Postulacion postulacionToPersist = Optional.ofNullable(postulacion)
                                           .map(
                                                    p -> {
                                                        usuarioRepository.findById(p.getUsuario())
                                                                         .orElseThrow(
                                                                                 //()->new
                                                                         )

                                                        adopcionRepository.findById(p.getAdopcion())
                                                                            .orElseThrow(
                                                                                    //()->
                                                                            )

                                                                //hacer esto en el mapper
                                                        return Postulacion.builder()
                                                                          .usuario(usuario)
                                                                          .adopcion(adopcion)
                                                                          .fecha(postulacion.getFecha());
                                                    }
                                           )
                                            .map(postulacionRepository::save)
                                            .orElseThrow(ChangeSetPersister.NotFoundException::new);

        return postulacionMapper.toPostulacionDTO(postulacionToPersist);

    }


    public List<PostulacionDTO> getAllPostulaciones(){}

    //crear servicio de MIS postulaciones
}