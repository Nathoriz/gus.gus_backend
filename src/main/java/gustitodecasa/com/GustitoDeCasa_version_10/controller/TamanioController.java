package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Entrega;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Tamanio;
import gustitodecasa.com.GustitoDeCasa_version_10.service.TamanioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tamanio")
public class TamanioController {

    @Autowired
    private TamanioService tamanioService;

    @GetMapping("/listar")
    public ResponseEntity<?> listarTamanio(){
        return ResponseEntity.status(HttpStatus.OK).body(tamanioService.listarTamanio());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> Guardar(@RequestBody Tamanio tamanio){
        return ResponseEntity.status(HttpStatus.OK).body(tamanioService.Guardar(tamanio));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> Actualizar(@RequestBody Tamanio tamanio){
        return tamanioService.Actualizar(tamanio);
    }

    @DeleteMapping("/borrar/{id}" )
    public void Eliminar( @PathVariable Long id ){
        tamanioService.Eliminar(id);
    }
}
