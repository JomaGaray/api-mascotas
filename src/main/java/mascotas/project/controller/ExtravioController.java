package mascotas.project.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mascotas.project.dto.ExtravioDTO;
import mascotas.project.services.ExtravioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extravios")
@AllArgsConstructor
@Slf4j
public class ExtravioController {

    private ExtravioService extravioService;

    @PostMapping(value = "")
    public ResponseEntity<Object> publicarExtravio ( @RequestBody ExtravioDTO extravioDTO){

        extravioService.saveExtravio(extravioDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
