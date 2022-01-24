package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProveedorInsumo;
import gustitodecasa.com.GustitoDeCasa_version_10.service.ProveedorInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proveedorinsumo")
public class ProveedorInsumoController {
    @Autowired
    private ProveedorInsumoService service;

    @GetMapping( "/listar/{id}" )
    public ResponseEntity<?> listarPorProveedorId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarPorProveedorId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }
    @PostMapping( "/registrar" )
    public ResponseEntity<?> guardar(@RequestBody ProveedorInsumo proveedorInsumo){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(proveedorInsumo));
    }

    @PutMapping( "/actualizar" )
    public ResponseEntity<?> actualizar( @RequestBody ProveedorInsumo proveedorInsumo ){
        return ResponseEntity.status( HttpStatus.OK ).body( service.actualizar(proveedorInsumo) );
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.eliminar(id));
    }
}
