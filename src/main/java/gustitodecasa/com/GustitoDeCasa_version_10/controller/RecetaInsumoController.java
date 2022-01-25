package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.RecetaInsumo;
import gustitodecasa.com.GustitoDeCasa_version_10.service.RecetaInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recetainsumo")
public class RecetaInsumoController {
    @Autowired
    private RecetaInsumoService service;

    @GetMapping( "/listar/{id}" )
    public ResponseEntity<?> listarPorRecetaId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarPorRecetaId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @PostMapping( "/registrar" )
    public ResponseEntity<?> guardar(@RequestBody RecetaInsumo recetaInsumo){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(recetaInsumo));
    }

    @PutMapping( "/actualizar" )
    public ResponseEntity<?> actualizar( @RequestBody RecetaInsumo recetaInsumo ){
        return ResponseEntity.status( HttpStatus.OK ).body( service.actualizar(recetaInsumo) );
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.eliminar(id));
    }
}
