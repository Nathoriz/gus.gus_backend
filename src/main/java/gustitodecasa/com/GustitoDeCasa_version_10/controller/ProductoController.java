package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Producto;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Proveedor;
import gustitodecasa.com.GustitoDeCasa_version_10.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/producto" )
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping( "/listar" )
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body( productoService.listar() );
    }

    @GetMapping( "/true/listar" )
    public ResponseEntity<?> ListarProducto(){
        return ResponseEntity.status(HttpStatus.OK).body( productoService.ListarProductosVisibles() );
    }

    @GetMapping( "/true/categoria/listar" )
    public ResponseEntity<?> ListarPorCategoria( String categoria ){
        if (categoria.equals("Todo")) {
            return ResponseEntity.status(HttpStatus.OK).body( productoService.ListarProductosVisibles() );
        }else{
            return ResponseEntity.status( HttpStatus.OK ).body( productoService.listarProductosVisiblesPorCategoria( categoria ) );
        }
    }

    @GetMapping( "/true/filtro" )
    public ResponseEntity<?> FiltroVisibleProducto( String nombre ){
        return ResponseEntity.status( HttpStatus.OK ).body( productoService.filtroVisiblesProductos( nombre ) );
    }

    @GetMapping( "/filtro" )
    public ResponseEntity<?> FiltroTodosProducto( String nombre ){
        return ResponseEntity.status( HttpStatus.OK ).body( productoService.filtroTdosProductos( nombre ) );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<?> DetalleProducto(@PathVariable( "id" ) Long id){
        return productoService.detalleProducto( id );
    }

    @GetMapping( "/buscar/{id}" )
    public Producto buscarPorID(@PathVariable( "id" ) Long id){
        return productoService.findProductoForid(id);
    }

    @GetMapping( "/find/{id}" )
    public ResponseEntity<?> findListProductForId( @PathVariable( "id" ) Long id ){
        return ResponseEntity.status( HttpStatus.OK ).body( productoService.findForid( id ) );
    }

    @PostMapping( "/registrar" )
    public ResponseEntity<?> guardar(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.guardar(producto));
    }

    @PutMapping( "/actualizar" )
    public ResponseEntity<?> actualizar( @RequestBody Producto producto ){
        return ResponseEntity.status( HttpStatus.OK ).body( productoService.actualizar(producto) );
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.eliminar(id));
    }
}
