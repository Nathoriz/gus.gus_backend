package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Altura;
import gustitodecasa.com.GustitoDeCasa_version_10.service.AlturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/altura")
public class AlturaController {
    @Autowired
    private AlturaService alturaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(alturaService.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Altura altura){
        return ResponseEntity.status(HttpStatus.OK).body(alturaService.guardar(altura));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Altura altura){
        return alturaService.actualizar(altura);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){ return alturaService.eliminar(id);}

    @GetMapping("/{id}")
    public Altura buscar(@PathVariable("id") Long id){
        return alturaService.buscar(id);
    }

}
