package mascotas.project.controller;


import lombok.extern.slf4j.Slf4j;
import mascotas.project.dto.AdopcionDTO;
import mascotas.project.entities.Adopcion;
import mascotas.project.services.AdopcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopciones")
@Slf4j
public class AdopcionController {

    @Autowired
    private AdopcionService adopcionService;

    @PostMapping
    public ResponseEntity<Adopcion> saveAdopcion(@RequestBody AdopcionDTO mascotaDTORequest) throws ChangeSetPersister.NotFoundException {
        Adopcion adopcion = adopcionService.saveAdopcion(mascotaDTORequest);
        return  ResponseEntity.ok().body(adopcion);
    }

    @GetMapping
    public ResponseEntity<List<Adopcion>> getAllAdopciones() throws ChangeSetPersister.NotFoundException {
        List<Adopcion> adopciones = adopcionService.findAll();
        return  ResponseEntity.ok().body(adopciones);
    }
}
