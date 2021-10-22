package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.Utils.MHelpers;
import gustitodecasa.com.GustitoDeCasa_version_10.Utils.other.UsuarioDTO;
import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Cliente;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Rol;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Usuario;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ClienteRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.RolRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RolRepository rolRepository;

    public Usuario RegistrarUsuario(UsuarioDTO usuarioDTO){
        if( usuarioDTO.getUsuario() == null ) throw new BadRequest( "Ingrese un nombre de usuario." );
        if( usuarioDTO.getUsuario().isEmpty() ) throw new BadRequest( "Ingrese un nombre de usuario." );
        Usuario username = usuarioRepository.findByUsuario( usuarioDTO.getUsuario() );
        if( username != null ) throw new BadRequest( "El nombre de usuario ya existe." );
        usuarioDTO.setUsuario( usuarioDTO.getUsuario() );

        if( usuarioDTO.getContrasenia() == null ) throw new BadRequest( "Ingrese una contraseña.");
        if( usuarioDTO.getContrasenia().isEmpty() ) throw new BadRequest( "Ingrese una contraseña.");
        else {
            if( usuarioDTO.getContrasenia().length() < 8 )
                throw new BadRequest( "Ingrese correctamente la contraseña (8 dígitos mínimo)." );
            usuarioDTO.setContrasenia( usuarioDTO.getContrasenia() );
        }

        if( usuarioDTO.getCliente().getTelefono() == null ) throw new BadRequest( "Ingrese el cliente." );
        if( usuarioDTO.getCliente().getTelefono().isEmpty() ) throw new BadRequest( "Ingrese el cliente." );
        else {
            Cliente cliente = clienteRepository.findByTelefono( usuarioDTO.getCliente().getTelefono() );
            if( cliente != null ){
                usuarioDTO.setCliente( cliente );
            }
        }
        if( usuarioDTO.getRol() == null || usuarioDTO.getRol().getId() == 0 ){
            Rol clienteRol = rolRepository.findRolByTiporol( "CLIENTE" );
            usuarioDTO.setRol( clienteRol );
        }
        Usuario usuario = MHelpers.modelMapper().map( usuarioDTO, Usuario.class );

        return usuarioRepository.save( usuario );
    }
}
