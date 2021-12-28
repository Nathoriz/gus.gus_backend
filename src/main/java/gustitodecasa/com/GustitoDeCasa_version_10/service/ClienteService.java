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
        if( cliente.getNombre() == null || cliente.getNombre().isEmpty() ) throw new BadRequest( "Ingrese su nombre." );
        cliente.setNombre(cliente.getNombre() );

        if( cliente.getApellido() == null  || cliente.getApellido().isEmpty() ) throw new BadRequest( "Ingrese su apellido." );
        cliente.setApellido( cliente.getApellido() );

        if( cliente.getTelefono() == null || cliente.getTelefono().isEmpty()) throw new BadRequest( "Ingrese su número telefónico." );
        else {
            if( cliente.getTelefono().length() < 9 || cliente.getTelefono().length() > 9) throw new BadRequest( "Ingrese correctamente su número." );
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

        if( Ncliente.getNombre().isEmpty() || Ncliente.getNombre() == null ) throw new BadRequest( "Ingrese su nuevo nombre." );
        cliente.setNombre( Ncliente.getNombre());

        if( Ncliente.getApellido().isEmpty() || Ncliente.getApellido() == null ) throw new BadRequest( "Ingrese su nuevo apellido." );
        cliente.setApellido( Ncliente.getApellido());

        if( Ncliente.getTelefono().isEmpty() || Ncliente.getTelefono() == null ) throw new BadRequest( "Ingrese su nuevo número telefónico." );
        else{
            if( Ncliente.getTelefono().length() < 9 || Ncliente.getTelefono().length() > 9 ) throw new BadRequest( "Ingrese correctamente su número." );
            cliente.setTelefono( Ncliente.getTelefono() );
        }

        return clienteRepository.save( cliente );
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

}
