package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Detalle;
import gustitodecasa.com.GustitoDeCasa_version_10.service.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalles")
public class DetalleController {
    @Autowired
    private DetalleService service;


    @GetMapping( "/listar" )
    public ResponseEntity<?> listarDetalles(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDetalle(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @PostMapping( "/registrar" )
    public ResponseEntity<?> guardarDetalle(@RequestBody Detalle detalle){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(detalle));
    }

    @PutMapping( "/actualizar" )
    public ResponseEntity<?> actualizarDetalle( @RequestBody Detalle detalle ){
        return ResponseEntity.status( HttpStatus.OK ).body( service.actualizar(detalle));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarDetalle(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.eliminar(id));
    }
}
