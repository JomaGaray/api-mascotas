package mascotas.project.services;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mascotas.project.dto.UsuarioDTO;
import mascotas.project.entities.Usuario;
import mascotas.project.mapper.UsuarioMapper;
import mascotas.project.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioMapper usuarioMapper;

    @Transactional
    public UsuarioDTO getUsuarioById(Long idUsuario) throws ChangeSetPersister.NotFoundException {

        Usuario usuario = usuarioRepository.findById(idUsuario)
                                            .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        return  usuarioMapper.toUsuarioDto(usuario);
    }

}
