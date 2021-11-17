package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Altura;
import gustitodecasa.com.GustitoDeCasa_version_10.service.AlturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tamanio")
public class TamanioController {

    @Autowired
    private AlturaService alturaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listarTamanio(){
        return ResponseEntity.status(HttpStatus.OK).body(alturaService.listarTamanio());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> Guardar(@RequestBody Altura altura){
        return ResponseEntity.status(HttpStatus.OK).body(alturaService.Guardar(altura));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> Actualizar(@RequestBody Altura altura){
        return alturaService.Actualizar(altura);
    }

    @DeleteMapping("/borrar/{id}" )
    public void Eliminar( @PathVariable Long id ){
        alturaService.Eliminar(id);
    }
}
