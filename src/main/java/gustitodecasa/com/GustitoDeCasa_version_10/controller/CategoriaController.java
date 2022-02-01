package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Categoria;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Insumo;
import gustitodecasa.com.GustitoDeCasa_version_10.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/categoria" )
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping( "/listar" )
    public ResponseEntity<?> ListarCategoria(){
        return ResponseEntity.status( HttpStatus.OK ).body( categoriaService.listar() );
    }

    @GetMapping( "/listarAll" )
    public ResponseEntity<?> ListarCategoriaAll(){
        return ResponseEntity.status( HttpStatus.OK ).body( categoriaService.listarAll() );
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.guardar(categoria));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Categoria categoria){
        return categoriaService.actualizar(categoria);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){ return categoriaService.eliminar(id);}

    @GetMapping("/{id}")
    public Categoria buscar(@PathVariable("id") Long id){
        return categoriaService.buscar(id);
    }

    @GetMapping( "/buscar" )
    public Categoria buscarPorNombre(String nombre ){
        return categoriaService.buscarPorNombre(nombre);
    }
}
