package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.Utils.MHelpers;
import gustitodecasa.com.GustitoDeCasa_version_10.Utils.other.AdminDTO;
import gustitodecasa.com.GustitoDeCasa_version_10.Utils.other.UserDetailDTO;
import gustitodecasa.com.GustitoDeCasa_version_10.Utils.other.UsuarioDTO;
import gustitodecasa.com.GustitoDeCasa_version_10.Utils.other.UsuarioLoginDTO;
import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.custom.CustomPasswordEncoder;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Admin;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Cliente;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Rol;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Usuario;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.AdminRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ClienteRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.RolRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;

    @Autowired
    private AdminRepository adminRepository;


    public Usuario RegistrarUsuario(UsuarioDTO usuarioDTO){
        if( usuarioDTO.getUsuario() == null ) throw new BadRequest( "Ingrese un nombre de usuario." );
        if( usuarioDTO.getUsuario().isEmpty() ) throw new BadRequest( "Ingrese un nombre de usuario." );

        Usuario username = usuarioRepository.findByUsuario( usuarioDTO.getUsuario() );

        if( username != null ) throw new BadRequest( "El nombre de usuario ya existe." );
        usuarioDTO.setUsuario( usuarioDTO.getUsuario() );

        if( usuarioDTO.getContrasenia() == null ) throw new BadRequest( "Ingrese una contraseña." );
        if( usuarioDTO.getContrasenia().isEmpty() ) throw new BadRequest( "Ingrese una contraseña." );
        else {
            if( usuarioDTO.getContrasenia().length() < 8 )
                throw new BadRequest( "Ingrese correctamente la contraseña (8 dígitos mínimo)." );
            usuarioDTO.setContrasenia( customPasswordEncoder.encode(usuarioDTO.getContrasenia()) );
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

    public Usuario RegistrarAdmin(AdminDTO adminDTO){
        if( adminDTO.getUsuario().isEmpty() ) throw new BadRequest( "Ingrese un nombre de usuario." );
        if( adminDTO.getUsuario() == null ) throw new BadRequest( "Ingrese un nombre de usuario." );
        else {
            if( usuarioRepository.existsUsuarioByUsuario(adminDTO.getUsuario() ) ) throw new BadRequest( "El nombre de usuario ya existe." );
            adminDTO.setUsuario( adminDTO.getUsuario() );
        }

        if( adminDTO.getContrasenia().isEmpty() ) throw new BadRequest( "Ingrese una contraseña." );
        if( adminDTO.getContrasenia() == null ) throw new BadRequest( "Ingrese una contraseña." );
        adminDTO.setContrasenia( customPasswordEncoder.encode( adminDTO.getContrasenia() ) );

        if( adminDTO.getAdmin().getDni().isEmpty() ) throw new BadRequest( "Ingrese un admin" );
        if( adminDTO.getAdmin().getDni() == null) throw new BadRequest( "Ingrese un admin" );
        else {
            Admin DNI = adminRepository.findAdminByDni( adminDTO.getAdmin().getDni() );
            if(  DNI != null ){
                adminDTO.setAdmin( DNI );
            }
        }
        if( adminDTO.getRol() == null || adminDTO.getRol().getId() == 0 ){
            Rol admin = rolRepository.findRolByTiporol( "ADMIN" );
            adminDTO.setRol( admin );
        }
        Usuario admin = MHelpers.modelMapper().map( adminDTO, Usuario.class );

        return usuarioRepository.save( admin );
    }

    public ResponseEntity<?> loginUsuario( UsuarioLoginDTO usuarioLoginDTO ){
        Map<String, Object> response = new HashMap<>();

        String username = usuarioLoginDTO.getUsuario();
        String password = usuarioLoginDTO.getContrasenia();

        if( username.isEmpty() ) throw new BadRequest( "Ingrese su nombre de usuario." );
        if( password.isEmpty() ) throw new BadRequest( "Ingrese su constraseña." );
        else {
            if( usuarioRepository.existsUsuarioByUsuario(username) ){
                Usuario user = usuarioRepository.findByUsuario( username );

                if( customPasswordEncoder.matches( password, user.getContrasenia() ) ){
                    UserDetailDTO detailDTO = MHelpers.modelMapper().map( user, UserDetailDTO.class );
                    response.put("Usuario", detailDTO );
                    response.put("estado", true );
                    return new ResponseEntity<>( response, HttpStatus.OK );
                }else {
                    response.put("ErrorMessage", "La contraseña es incorrecta." );
                    return new ResponseEntity<>( response, HttpStatus.UNAUTHORIZED );
                }
            }else {
                response.put("ErrorMessage", "El nombre de usuario o la contraseña son incorrectas." );
                return new ResponseEntity<>( response, HttpStatus.UNAUTHORIZED );
            }
        }
    }

    @Override
    public UserDetails loadUserByUsername( String s ) throws UsernameNotFoundException {
        Usuario usuario = new Usuario();
        return new org.springframework.security.core.userdetails.User( usuario.getUsuario(),
                usuario.getContrasenia(), Collections.emptyList() );
    }
}
