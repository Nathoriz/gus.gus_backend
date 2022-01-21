package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.*;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ClienteRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.EntregaRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.EstadoRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    public Pedido buscar(Long id){return repository.findById(id).orElse(null);}

    public List<Pedido> listar(){return repository.findAll();}

    public List<Pedido> listarPorClienteID(Long id) {
        Cliente cliente = clienteRepository.findClienteById(id);
        if(cliente!=null) return repository.findAllByCliente_Id(cliente.getId());
        else throw new BadRequest("Cliente no existe");
    }

    public List<Pedido> listarPorClientIdAndEstadoNombre(String estadonombre, Long id){
        Estado estado = estadoRepository.findEstadoByNombre(estadonombre);
        if(estado!=null) return repository.findAllByEstado_NombreAndCliente_Id(estado.getNombre(), id );
        else throw new BadRequest("Estado no existe");
    }

    public Pedido guardar(Pedido pedido){
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId()).orElse(null);
        if(cliente != null) pedido.setCliente(cliente);
        else throw new BadRequest("El cliente no existe");

        if(pedido.getFechaPedido()!= null) pedido.setFechaPedido(pedido.getFechaPedido());
        else throw  new BadRequest("Ingrese fecha de creación del pedido");

        Entrega entrega = entregaRepository.findById(pedido.getEntrega().getId()).orElse(null);
        if(entrega !=null) pedido.setEntrega(entrega);
        else throw new BadRequest("Ingrese entrega");

        Estado estado = estadoRepository.findById(pedido.getEstado().getId()).orElse(null);
        if(estado != null) pedido.setEstado(estado);
        else throw new BadRequest("Ingrese el estado");

        if(pedido.getMonto()!= null) pedido.setMonto(pedido.getMonto());
        else throw  new BadRequest("Ingrese monto del pedido");

        return repository.save(pedido);
    }

    public ResponseEntity<?> actualizar(Pedido pedido){
        Map<String, String> message = new HashMap<>();
        Pedido object = repository.findById(pedido.getId()).orElse(null);
        if(object != null){
            object.setCliente(pedido.getCliente());
            object.setFechaPedido(pedido.getFechaPedido());
            object.setEntrega(pedido.getEntrega());
            object.setEstado(pedido.getEstado());
            object.setMonto(pedido.getMonto());
            repository.save(object);
            message.put("Mensaje","Ok");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        message.put("Mensaje","El pedido no existe");
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> eliminar(Long id){
        Map<String, String> message = new HashMap<>();

        Pedido pedido = repository.findById(id).orElse(null);
        if( pedido.equals(null)) {
            message.put("Mensaje","El pedido no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        message.put("Mensaje","Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public List<Pedido> buscarClientePedidoIdLike(Long id,String estado, String pedidoId){
        return repository.buscarPedidoClientePorID(id,estado,pedidoId);
    }

}
