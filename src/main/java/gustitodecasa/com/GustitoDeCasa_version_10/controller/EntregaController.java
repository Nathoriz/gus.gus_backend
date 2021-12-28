package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Entrega;
import gustitodecasa.com.GustitoDeCasa_version_10.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
    @Autowired
    private EntregaService entregaService;

    //metodo para listar
    @GetMapping("/listar")
    public ResponseEntity<?> listarEntrega(){
       return ResponseEntity.status(HttpStatus.OK).body(entregaService.listarEntrega());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> Guardar(@RequestBody Entrega entrega){
        return ResponseEntity.status(HttpStatus.OK).body(entregaService.Guardar(entrega));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> Actualizar(@RequestBody Entrega entrega){
        return entregaService.Actualizar(entrega);
    }

}
