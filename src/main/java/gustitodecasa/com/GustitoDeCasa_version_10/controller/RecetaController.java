package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Receta;
import gustitodecasa.com.GustitoDeCasa_version_10.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receta")
public class RecetaController {
    @Autowired
    private RecetaService service;

    @GetMapping( "/listar" )
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }
    @PostMapping( "/registrar" )
    public ResponseEntity<?> guardar(@RequestBody Receta receta){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(receta));
    }

    @PutMapping( "/actualizar" )
    public ResponseEntity<?> actualizar( @RequestBody Receta receta ){
        return ResponseEntity.status( HttpStatus.OK ).body( service.actualizar(receta) );
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.eliminar(id));
    }
}
