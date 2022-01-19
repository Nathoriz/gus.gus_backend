package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Pedido;
import gustitodecasa.com.GustitoDeCasa_version_10.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @GetMapping( "/listar" )
    public ResponseEntity<?> listarPedidos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPedido(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> listarPorClienteID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarPorClienteID(id));
    }

    @GetMapping("/estado/{nombre}/{id}")
    public ResponseEntity<?> listarPorEstado(@PathVariable("nombre") String nombre, @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarPorEstado(nombre,  id));
    }

    @PostMapping( "/registrar" )
    public ResponseEntity<?> guardarPedido(@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(pedido));
    }

    @PutMapping( "/actualizar" )
    public ResponseEntity<?> actualizarCliente( @RequestBody Pedido pedido ){
        return ResponseEntity.status( HttpStatus.OK ).body( service.actualizar(pedido) );
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPedido(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.eliminar(id));
    }
}
