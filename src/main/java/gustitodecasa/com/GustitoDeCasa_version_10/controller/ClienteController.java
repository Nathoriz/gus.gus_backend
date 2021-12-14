package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Cliente;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Distrito;
import gustitodecasa.com.GustitoDeCasa_version_10.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
=======

import java.util.List;
>>>>>>> master

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping( "/registrar" )
    public ResponseEntity<?> RegistrarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.Registrar( cliente ));
    }

<<<<<<< HEAD
    @PostMapping( "/{id}" )
    public ResponseEntity<?> FindCliente( @PathVariable( "id" ) Long id ){
        return ResponseEntity.status( HttpStatus.OK ).body( clienteService.findById( id ) );
    }

    @PutMapping( "/update" )
    public ResponseEntity<?> UpdateCliente( @RequestBody Cliente cliente ){
        return ResponseEntity.status( HttpStatus.OK ).body( clienteService.Update( cliente ) );
    }
=======



>>>>>>> master
}
