package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.Utils.other.UsuarioDTO;
import gustitodecasa.com.GustitoDeCasa_version_10.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/usuario" )
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping( "/registrar" )
    public ResponseEntity<?> RegistrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.status( HttpStatus.OK ).body( usuarioService.RegistrarUsuario(usuarioDTO) );
    }
}
