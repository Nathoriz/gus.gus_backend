package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoSabor;
import gustitodecasa.com.GustitoDeCasa_version_10.service.ProductoSaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productosabor")
public class ProductoSaborController {
    @Autowired
    private ProductoSaborService service;

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ProductoSabor productoSabor){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(productoSabor));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody ProductoSabor productoSabor){
        return service.actualizar(productoSabor);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){ return service.eliminar(id);}

    @GetMapping("/{id}")
    public ProductoSabor buscar(@PathVariable("id") Long id){
        return service.buscar(id);
    }
}
