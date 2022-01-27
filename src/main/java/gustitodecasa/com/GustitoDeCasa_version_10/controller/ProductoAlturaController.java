package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoAltura;
import gustitodecasa.com.GustitoDeCasa_version_10.service.ProductoAlturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productoaltura")
public class ProductoAlturaController {
    @Autowired
    private ProductoAlturaService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ProductoAltura productoAltura){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(productoAltura));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody ProductoAltura productoAltura){
        return service.actualizar(productoAltura);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){ return service.eliminar(id);}

    @GetMapping("/{id}")
    public ProductoAltura buscar(@PathVariable("id") Long id){
        return service.buscar(id);
    }

//    @GetMapping( "/buscar" )
//    public Altura buscarPorNombre(String nombre ){
//        return service.buscarPorNombre(nombre);
//    }

}
