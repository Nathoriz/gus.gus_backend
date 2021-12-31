package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Noticias;
import gustitodecasa.com.GustitoDeCasa_version_10.service.NoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/noticias" )
public class NoticiasController {

    @Autowired
    private NoticiasService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Noticias noticias){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(noticias));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Noticias noticias){
        return service.actualizar(noticias);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){ service.eliminar(id);}

    @GetMapping( "/visibilidad" )
    public ResponseEntity<?> FindNoticiabyVisibilidad( Boolean aBoolean ){
        return ResponseEntity.status( HttpStatus.OK ).body( service.listaVisible( aBoolean ) );
    }
}
