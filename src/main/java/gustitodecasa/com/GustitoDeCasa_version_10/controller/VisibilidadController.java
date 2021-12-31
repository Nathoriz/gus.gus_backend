package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.service.VisibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/visibilidad" )
public class VisibilidadController {

    @Autowired
    private VisibilidadService visibilidadService;

    @GetMapping( "/buscar" )
    public ResponseEntity<?> findByFalseOrTrue( Boolean aBoolean ){
        return ResponseEntity.status( HttpStatus.OK ).body( visibilidadService.findByTryeOrFalse( aBoolean ) );
    }
}
