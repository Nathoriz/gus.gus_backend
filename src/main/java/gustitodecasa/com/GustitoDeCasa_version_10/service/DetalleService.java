package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Detalle;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Pedido;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.DetalleRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DetalleService {
    @Autowired
    private DetalleRepository repository;
    @Autowired
    private PedidoRepository pedidoRepository;

    public Detalle buscar(Long id){return repository.findById(id).orElse(null);}

    public List<Detalle> listar(){
        return repository.findAll();
    }

    public Detalle guardar(Detalle detalle){
        Pedido pedido = pedidoRepository.findById(detalle.getPedido().getId()).orElse(null);
        if(pedido != null) detalle.setPedido(pedido);
        else throw  new BadRequest("Ingrese el pedido");
        detalle.setFrase(detalle.getFrase());
        detalle.setObservacion(detalle.getObservacion());
        return repository.save(detalle);
    }

    public ResponseEntity<?> actualizar(Detalle detalle){
        Map<String, String> message = new HashMap<>();
        Detalle object = repository.findById(detalle.getId()).orElse(null);
        if(detalle!=null){
            object.setPedido(detalle.getPedido());
            object.setFrase(detalle.getFrase());
            object.setObservacion(detalle.getObservacion());
            repository.save(object);
            message.put("Mensaje","Ok");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        message.put("Mensaje","El detalle no existe");
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> eliminar(Long id){
        Map<String, String> message = new HashMap<>();

        Detalle detalle = repository.findById(id).orElse(null);
        if( detalle.equals(null)) {
            message.put("Mensaje","El detalle no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        message.put("Mensaje","Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
