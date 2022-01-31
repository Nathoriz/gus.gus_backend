package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoRelleno;
import gustitodecasa.com.GustitoDeCasa_version_10.service.ProductoRellenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productorelleno")
public class ProductoRellenoController {
    @Autowired
    private ProductoRellenoService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ProductoRelleno productoRelleno){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(productoRelleno));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody ProductoRelleno productoRelleno){
        return service.actualizar(productoRelleno);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){ return service.eliminar(id);}

    @GetMapping("/{id}")
    public ProductoRelleno buscar(@PathVariable("id") Long id){
        return service.buscar(id);
    }
}
