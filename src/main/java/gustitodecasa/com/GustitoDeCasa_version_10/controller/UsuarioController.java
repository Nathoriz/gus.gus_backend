package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.Utils.other.*;
import gustitodecasa.com.GustitoDeCasa_version_10.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/usuario" )
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping( "/registrarUsuario" )
    public ResponseEntity<?> RegistrarUsuario( @RequestBody UsuarioDTO usuarioDTO ){
        return ResponseEntity.status( HttpStatus.OK ).body( usuarioService.RegistrarUsuario( usuarioDTO ) );
    }

    @PostMapping( "/registrarAdmin" )
    public ResponseEntity<?> RegistrarAdmin( @RequestBody AdminDTO adminDTO ){
        return ResponseEntity.status( HttpStatus.OK ).body( usuarioService.RegistrarAdmin(adminDTO) );
    }

    @PostMapping( "/login" )
    public ResponseEntity<?> Login( @RequestBody UsuarioLoginDTO loginDTO ){
        return usuarioService.loginUsuario( loginDTO );
    }

    @PostMapping( "/validar" )
    public ResponseEntity<?> ValidarPassword( @RequestBody PasswordDTO passwordDTO ){
        return usuarioService.ValidarPassword( passwordDTO );
    }

    @PutMapping( "/update" )
    public ResponseEntity<?> CambiarPassword(@RequestBody NuevoPasswordDTO nuevoPasswordDTO){
        return usuarioService.CambiarPassword( nuevoPasswordDTO );
    }
}
