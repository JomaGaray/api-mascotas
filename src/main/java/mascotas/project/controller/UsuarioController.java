package mascotas.project.controller;

import lombok.extern.slf4j.Slf4j;
import mascotas.project.dto.UsuarioDTO;
import mascotas.project.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@Slf4j
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> getUsuariobyID(@PathVariable(name = "id", required = true) Long idUsuario) throws ChangeSetPersister.NotFoundException {
        UsuarioDTO mascota = usuarioService.getUsuarioById(idUsuario);
        return ResponseEntity.ok().body(mascota);
    }

}