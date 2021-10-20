package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Diametro;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Relleno;
import gustitodecasa.com.GustitoDeCasa_version_10.service.RellenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relleno")
public class RellenoController {
    @Autowired
    private RellenoService rellenoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(rellenoService.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Relleno relleno){
        return ResponseEntity.status(HttpStatus.OK).body(rellenoService.guardar(relleno));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Relleno relleno){
        return rellenoService.actualizar(relleno);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){ rellenoService.eliminar(id);}

}
