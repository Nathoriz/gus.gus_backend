package gustitodecasa.com.GustitoDeCasa_version_10.controller;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Relleno;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Sabor;
import gustitodecasa.com.GustitoDeCasa_version_10.service.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sabor")
public class SaborController {
    @Autowired
    private SaborService saborService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(saborService.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Sabor sabor){
        return ResponseEntity.status(HttpStatus.OK).body(saborService.guardar(sabor));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Sabor sabor){
        return saborService.actualizar(sabor);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){ return saborService.eliminar(id);}


    @GetMapping("/{id}")
    public Sabor buscar(@PathVariable("id") Long id){
        return saborService.buscar(id);
    }


}