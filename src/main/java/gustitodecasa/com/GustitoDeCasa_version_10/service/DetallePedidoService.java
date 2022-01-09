package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.*;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.DetallePedidoRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.PedidoRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.PersonalizacionRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository repository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProductoRespository productoRespository;
    @Autowired
    private PersonalizacionRepository personalizacionRepository;

    public DetallePedido buscar(Long id) { return repository.findById(id).orElse(null);}

    public List<DetallePedido> listar() { return  repository.findAll();}

    public DetallePedido guardar(DetallePedido detallePedido){
        Pedido pedido = pedidoRepository.findById(detallePedido.getPedido().getId()).orElse(null);

        if(pedido != null ) detallePedido.setPedido(pedido);
        else throw new BadRequest("Ingrese pedido");

        Personalizacion personalizacion = personalizacionRepository.findById(detallePedido.getPersonalizacion().getId()).orElse(null);
        Producto producto = productoRespository.findById(detallePedido.getProducto().getId()).orElse(null);

        if(producto != null && personalizacion !=null) throw  new BadRequest("Solo puede ingresar producto o personalización, no ambos");
        else if (producto !=null) detallePedido.setProducto(producto);
        else if (personalizacion != null) detallePedido.setPersonalizacion(personalizacion);
        else  throw new BadRequest("Error en el ingreso de producto o personalización");

        if(detallePedido.getCantidad() >= 1) detallePedido.setCantidad(detallePedido.getCantidad());
        else throw new BadRequest("La cantidad no puede ser 0 o menos");

        if(detallePedido.getSubtotal() != 0.0) detallePedido.setSubtotal(detallePedido.getSubtotal());
        else {
            Double monto = producto.getPrecio() * detallePedido.getCantidad();
            detallePedido.setSubtotal(monto);
        }
        return repository.save(detallePedido);
    }

    public ResponseEntity<?> actualizar(DetallePedido detallePedido){
        Map<String, String> message = new HashMap<>();
        DetallePedido object = repository.findById(detallePedido.getId()).orElse(null);
        if(object!=null) {
            Pedido pedido = pedidoRepository.findById(object.getPedido().getId()).orElse(null);
            if (pedido !=null) object.setPedido(pedido);

            Personalizacion personalizacion = personalizacionRepository.findById(object.getPersonalizacion().getId()).orElse(null);
            Producto producto = productoRespository.findById(detallePedido.getProducto().getId()).orElse(null);
            if (personalizacion != null) object.setPersonalizacion(personalizacion);
            else if (producto != null)  object.setProducto(producto);
            else  throw new BadRequest("Surgio un problema con la actualización de producto o personalización");

            object.setCantidad(detallePedido.getCantidad());
            if(object.getSubtotal() != 0.0)  object.setSubtotal(detallePedido.getSubtotal());
            else {
                Double monto = object.getProducto().getPrecio() * object.getCantidad();
                detallePedido.setSubtotal(monto);
            }

            repository.save(object);
            message.put("Mensaje","Ok");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        message.put("Mensaje","El detalle pedido no existe");
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> eliminar(Long id){
        Map<String, String> message = new HashMap<>();

        DetallePedido detallePedido = repository.findById(id).orElse(null);
        if( detallePedido.equals(null)) {
            message.put("Mensaje","El detalle pedido no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        message.put("Mensaje","Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
