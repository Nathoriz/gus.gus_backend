package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoAltura;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoDiametro;
import gustitodecasa.com.GustitoDeCasa_version_10.service.ProductoDiametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productodiametro")
public class ProductoDiametroController {
    @Autowired
    private ProductoDiametroService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ProductoDiametro productoDiametro){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(productoDiametro));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody ProductoDiametro productoDiametro){
        return service.actualizar(productoDiametro);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){ return service.eliminar(id);}

    @GetMapping("/{id}")
    public ProductoDiametro buscar(@PathVariable("id") Long id){
        return service.buscar(id);
    }
}
