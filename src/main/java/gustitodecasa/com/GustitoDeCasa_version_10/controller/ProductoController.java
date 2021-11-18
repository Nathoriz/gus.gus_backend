package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/producto" )
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping( "/listarAll" )
    public ResponseEntity<?> ListarProducto(){
        return ResponseEntity.status(HttpStatus.OK).body( productoService.ListarProductos() );
    }
}
