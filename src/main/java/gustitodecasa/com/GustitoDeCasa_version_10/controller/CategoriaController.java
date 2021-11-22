package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/categoria" )
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping( "/listar" )
    public ResponseEntity<?> ListarCategoria(){
        return ResponseEntity.status( HttpStatus.OK ).body( categoriaService.listar() );
    }
}
