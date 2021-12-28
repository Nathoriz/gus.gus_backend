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
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Entrega> listarEntrega(){
        return entregaRepository.findAll();
    }

    public Entrega Guardar(Entrega entrega){
        Pedido pedido = pedidoRepository.findById(entrega.getPedido().getId()).orElse(null);
        if(pedido.equals(null) || pedido == null) throw new BadRequest("Ingrese pedido");

        if(entrega.getFecha().isEmpty() && entrega.getHora().isEmpty()) throw new BadRequest("Ingrese la Fecha y Hora");
        if(entrega.getHora().isEmpty() || entrega.getFecha().isEmpty()){
            if(entrega.getHora().isEmpty()){
                throw new BadRequest("Ingrese la hora");
            }else {
                throw new BadRequest("Ingrese la fecha");
            }
        }

        if( entrega.getDistrito() == null || entrega.getDistrito().getId() == 0 ) throw new BadRequest("Seleccione un distrito");
        Distrito distrito = distritoRepository.findById(entrega.getDistrito().getId()).orElse(null);
        if(distrito.equals(null) || distrito == null) throw new BadRequest("El distrito no existe");

        entrega.setPedido(entrega.getPedido());
        entrega.setFecha(entrega.getFecha());
        entrega.setHora(entrega.getHora());
        entrega.setDistrito(entrega.getDistrito());

        return entregaRepository.save(entrega);
    }

    public ResponseEntity<?> Actualizar(Entrega entrega){
        Entrega entrega1 = entregaRepository.findById(entrega.getId()).orElse(null);
        Pedido pedido = pedidoRepository.findById(entrega.getPedido().getId()).orElse(null);
        if(pedido.equals(null) || pedido == null) throw new BadRequest("El pedido no existe");
        entrega1.setPedido(entrega.getPedido());

        entrega1.setFecha(entrega.getFecha());
        entrega1.setHora(entrega.getHora());

        Distrito distrito = distritoRepository.findById(entrega.getDistrito().getId()).orElse(null);
        if(distrito.equals(null) || distrito == null) throw new BadRequest("El distrito no existe");
        entrega1.setDistrito(entrega.getDistrito());

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
