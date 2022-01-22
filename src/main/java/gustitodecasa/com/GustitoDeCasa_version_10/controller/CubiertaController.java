package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Cubierta;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Relleno;
import gustitodecasa.com.GustitoDeCasa_version_10.service.CubiertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cubierta")
public class CubiertaController {
    @Autowired
    private CubiertaService cubiertaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(cubiertaService.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Cubierta cubierta){
        return ResponseEntity.status(HttpStatus.OK).body(cubiertaService.guardar(cubierta));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Cubierta cubierta){
        return cubiertaService.actualizar(cubierta);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){ return cubiertaService.eliminar(id);}

    @GetMapping("/{id}")
    public Cubierta buscar(@PathVariable("id") Long id){
        return cubiertaService.buscar(id);
    }


}
