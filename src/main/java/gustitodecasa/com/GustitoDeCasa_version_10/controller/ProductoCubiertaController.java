package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoAltura;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoCubierta;
import gustitodecasa.com.GustitoDeCasa_version_10.service.ProductoCubiertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productocubierta")
public class ProductoCubiertaController {
    @Autowired
    private ProductoCubiertaService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ProductoCubierta productoCubierta){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(productoCubierta));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody ProductoCubierta productoCubierta){
        return service.actualizar(productoCubierta);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){ return service.eliminar(id);}

    @GetMapping("/{id}")
    public ProductoCubierta buscar(@PathVariable("id") Long id){
        return service.buscar(id);
    }
}
