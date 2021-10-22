package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Cliente;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente Registrar( Cliente cliente ){
        if( cliente.getNombreCompleto() == null ) throw new BadRequest( "Ingrese su nombre completo." );
        if( cliente.getNombreCompleto().isEmpty() ) throw new BadRequest( "Ingrese su nombre completo." );

        if( cliente.getDireccion() == null ) throw new BadRequest( "Ingrese su dirección." );
        if( cliente.getDireccion().isEmpty() ) throw new BadRequest( "Ingrese su dirección." );

        if( cliente.getTelefono() == null ) throw new BadRequest( "Ingrese su número telefónico." );
        if( cliente.getTelefono().isEmpty() ) throw new BadRequest( "Ingrese su número telefónico." );
        else {
            if( cliente.getTelefono().length() < 9 ) throw new BadRequest( "Ingrese correctamente su número." );
            if( cliente.getTelefono().length() > 9 ) throw new BadRequest( "Ingrese correctamente su número." );
            Cliente telefeno = clienteRepository.findByTelefono( cliente.getTelefono() );
            if( telefeno != null ) throw new BadRequest( "El número ya está registrado en otra cuenta." );
        }
        return clienteRepository.save( cliente );
    }

}
