package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Proveedor;
import gustitodecasa.com.GustitoDeCasa_version_10.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private ProveedorService service;

    @GetMapping( "/listar" )
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }
    @PostMapping( "/registrar" )
    public ResponseEntity<?> guardar(@RequestBody Proveedor proveedor){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(proveedor));
    }

    @PutMapping( "/actualizar" )
    public ResponseEntity<?> actualizar( @RequestBody Proveedor proveedor ){
        return ResponseEntity.status( HttpStatus.OK ).body( service.actualizar(proveedor) );
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.eliminar(id));
    }

}
