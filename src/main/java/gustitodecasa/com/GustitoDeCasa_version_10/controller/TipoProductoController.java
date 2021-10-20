package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.TipoProducto;
import gustitodecasa.com.GustitoDeCasa_version_10.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipoproducto")
public class TipoProductoController {

    @Autowired
    private TipoProductoService tipoProductoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(tipoProductoService.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody TipoProducto tipoProducto){
        return ResponseEntity.status(HttpStatus.OK).body(tipoProductoService.guardar(tipoProducto));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody TipoProducto tipoProducto){
        return tipoProductoService.actualizar(tipoProducto);
    }

    @DeleteMapping("/borrar/{id}" )
    public void eliminar( @PathVariable Long id ){
        tipoProductoService.eliminar(id);
    }
}
