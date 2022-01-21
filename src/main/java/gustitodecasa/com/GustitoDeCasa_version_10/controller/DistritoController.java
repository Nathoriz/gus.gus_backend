package gustitodecasa.com.GustitoDeCasa_version_10.controller;



import gustitodecasa.com.GustitoDeCasa_version_10.entity.Distrito;
import gustitodecasa.com.GustitoDeCasa_version_10.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distrito")
public class DistritoController {
    @Autowired
    private DistritoService distritoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(distritoService.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Distrito distrito){
        return ResponseEntity.status(HttpStatus.OK).body(distritoService.guardar(distrito));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Distrito distrito){
        return distritoService.actualizar(distrito);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){ distritoService.eliminar(id);}

    @GetMapping( "/buscar" )
    public ResponseEntity<?> BuscarDistrito( String nombre ){
        return ResponseEntity.status( HttpStatus.OK ).body( distritoService.buscar( nombre ) );
    }
}
