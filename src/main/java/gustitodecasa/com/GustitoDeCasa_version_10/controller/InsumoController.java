package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Insumo;
import gustitodecasa.com.GustitoDeCasa_version_10.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insumo")
public class InsumoController {
    @Autowired
    private InsumoService insumoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(insumoService.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Insumo insumo){
        return ResponseEntity.status(HttpStatus.OK).body(insumoService.guardar(insumo));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Insumo insumo){
        return insumoService.actualizar(insumo);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){ return insumoService.eliminar(id);}

    @GetMapping("/{id}")
    public Insumo buscar(@PathVariable("id") Long id){
        return insumoService.buscar(id);
    }
}
