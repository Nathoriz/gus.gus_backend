package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Personalizacion;
import gustitodecasa.com.GustitoDeCasa_version_10.service.PersonalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personalizacion")
public class PersonalizacionController {
    @Autowired
    private PersonalizacionService service;

    @GetMapping( "/listar" )
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> listarPorClienteID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarPorClienteID(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @PostMapping( "/registrar" )
    public ResponseEntity<?> guardar(@RequestBody Personalizacion personalizacion){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(personalizacion));
    }

    @PutMapping( "/actualizar" )
    public ResponseEntity<?> actualizar( @RequestBody Personalizacion personalizacion ){
        return ResponseEntity.status( HttpStatus.OK ).body( service.actualizar(personalizacion));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.eliminar(id));
    }
}
