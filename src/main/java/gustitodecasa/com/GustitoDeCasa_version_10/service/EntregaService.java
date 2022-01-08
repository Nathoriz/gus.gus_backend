package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Distrito;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Entrega;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Pedido;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.DistritoRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.EntregaRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EntregaService {
    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private DistritoRepository distritoRepository;


    public List<Entrega> listarEntrega(){
        return entregaRepository.findAll();
    }

    public Entrega Guardar(Entrega entrega){
        if( entrega.getDireccion().isEmpty() || entrega.getDireccion() == null ) throw new BadRequest("Ingrese su dirección.");
        entrega.setDireccion( entrega.getDireccion() );

        if( entrega.getFecha().isEmpty() || entrega.getFecha() == null ) throw new BadRequest("Ingrese una fecha.");
        entrega.setFecha( entrega.getFecha() );

        if( entrega.getHora().isEmpty() || entrega.getHora() == null ) throw new BadRequest( "Ingrese la hora." );
        entrega.setHora( entrega.getHora() );

        Distrito distri = distritoRepository.findDistritoByNombre( entrega.getDistrito().getNombre() );
        if( distri != null ){
            entrega.setDistrito( distri );
        }else {
            Distrito distrito = distritoRepository.findDistritoById( 1L );
            entrega.setDistrito( distrito );
        }

        return entregaRepository.save( entrega );
    }

    public ResponseEntity<?> Actualizar(Entrega entrega){
        Entrega entrega1 = entregaRepository.findById(entrega.getId()).orElse(null);
        entrega1.setFecha(entrega.getFecha());
        entrega1.setHora(entrega.getHora());

        Distrito distrito = distritoRepository.findById(entrega.getDistrito().getId()).orElse(null);
        if(distrito.equals(null) || distrito == null) throw new BadRequest("El distrito no existe");
        entrega1.setDistrito(entrega.getDistrito());
        entrega1.setDireccion( entrega.getDireccion() );

        entregaRepository.save(entrega1);

        //para darle un mensaje
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Actualizacion exitosa");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public void Eliminar(Long id){
        entregaRepository.deleteById(id);
    }
}
