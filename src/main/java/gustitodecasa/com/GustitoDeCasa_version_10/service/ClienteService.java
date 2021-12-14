package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.NotFound;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Cliente;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Distrito;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ClienteRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente Registrar( Cliente cliente ){
        if( cliente.getNombreCompleto() == null ) throw new BadRequest( "Ingrese su nombre completo." );
        if( cliente.getNombreCompleto().isEmpty() ) throw new BadRequest( "Ingrese su nombre completo." );
        cliente.setNombreCompleto(cliente.getNombreCompleto() );

        if( cliente.getDireccion() == null ) throw new BadRequest( "Ingrese su dirección." );
        if( cliente.getDireccion().isEmpty() ) throw new BadRequest( "Ingrese su dirección." );
        cliente.setDireccion( cliente.getDireccion() );

        if( cliente.getDistrito() == null ) throw new BadRequest( "Ingrese su dirección." );
        cliente.setDistrito( cliente.getDistrito());


        if( cliente.getTelefono() == null ) throw new BadRequest( "Ingrese su número telefónico." );
        if( cliente.getTelefono().isEmpty() ) throw new BadRequest( "Ingrese su número telefónico." );
        else {
            if( cliente.getTelefono().length() < 9 ) throw new BadRequest( "Ingrese correctamente su número." );
            if( cliente.getTelefono().length() > 9 ) throw new BadRequest( "Ingrese correctamente su número." );
            Cliente telefeno = clienteRepository.findByTelefono( cliente.getTelefono() );
            if( telefeno != null ) throw new BadRequest( "El número ya está registrado en otra cuenta." );
            cliente.setTelefono( cliente.getTelefono() );
        }
        return clienteRepository.save( cliente );
    }

    public Cliente findById( Long id ){
        return clienteRepository.findClienteById( id );
    }

    public Cliente Update( Cliente Ncliente ){
        Cliente cliente = clienteRepository.findClienteById( Ncliente.getId() );

        if( Ncliente.getNombreCompleto().isEmpty() || Ncliente.getNombreCompleto() == null )
            throw new BadRequest( "Ingrese su nuevo nombre Completo." );
        cliente.setNombreCompleto( Ncliente.getNombreCompleto() );

        if( Ncliente.getTelefono().isEmpty() || Ncliente.getTelefono() == null )
            throw new BadRequest( "Ingrese su nuevo número telefónico." );
        else{
            if( Ncliente.getTelefono().length() < 9 ) throw new BadRequest( "Ingrese correctamente su número." );
            if( Ncliente.getTelefono().length() > 9 ) throw new BadRequest( "Ingrese correctamente su número." );
            cliente.setTelefono( Ncliente.getTelefono() );
        }

        if( Ncliente.getDireccion().isEmpty() || Ncliente.getDireccion() == null )
            throw new BadRequest( "Ingrese su nueva dirección" );
        cliente.setDireccion( Ncliente.getDireccion() );

        if( cliente.getDistrito() == null ) throw new BadRequest( "Ingrese su dirección." );
        cliente.setDistrito( Ncliente.getDistrito());

        return clienteRepository.save( cliente );
    }
}
