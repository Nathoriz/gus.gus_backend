package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Pedido;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.PersonalizacionPiso;
import gustitodecasa.com.GustitoDeCasa_version_10.service.PersonalizacionPisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personalizacionpiso")
public class PersonalizacionPisoController {
    @Autowired
    private PersonalizacionPisoService service;



    @GetMapping( "/listar" )
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> listarPorPersonalizacionID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarPorPersonalizacionID(id));
    }


    @PostMapping( "/registrar" )
    public ResponseEntity<?> guardar(@RequestBody PersonalizacionPiso personalizacionPiso){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(personalizacionPiso));
    }

    @PutMapping( "/actualizar" )
    public ResponseEntity<?> actualizar( @RequestBody PersonalizacionPiso personalizacionPiso ){
        return ResponseEntity.status( HttpStatus.OK ).body( service.actualizar(personalizacionPiso));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.eliminar(id));
    }
}
