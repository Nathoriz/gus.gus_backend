package gustitodecasa.com.GustitoDeCasa_version_10.controller;


import gustitodecasa.com.GustitoDeCasa_version_10.entity.Diametro;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Entrega;
import gustitodecasa.com.GustitoDeCasa_version_10.service.DiametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diametro")
public class DiametroController {
    @Autowired
    private DiametroService diametroService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(diametroService.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Diametro diametro){
        return ResponseEntity.status(HttpStatus.OK).body(diametroService.guardar(diametro));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Diametro diametro){
        return diametroService.actualizar(diametro);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){ diametroService.eliminar(id);}
}
