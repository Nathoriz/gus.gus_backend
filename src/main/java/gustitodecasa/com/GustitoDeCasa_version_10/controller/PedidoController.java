package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Pedido;
import gustitodecasa.com.GustitoDeCasa_version_10.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @GetMapping( "/listar" )
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> listarPorClienteID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarPorClienteID(id));
    }

    @GetMapping("/estado/{nombre}/{id}")
    public ResponseEntity<?> listarPorClienteIdAndEstadoNombre(@PathVariable("nombre") String nombre, @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarPorClientIdAndEstadoNombre(nombre,  id));
    }

    @GetMapping("/cliente/{id}/{estado}/{pedidoid}")
    public ResponseEntity<?> buscarPedidosClientesPorId(@PathVariable("id") Long id, @PathVariable("estado") String estado,@PathVariable String pedidoid){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarClientePedidoIdLike(id, estado,pedidoid));
    }

    @PostMapping( "/registrar" )
    public ResponseEntity<?> guardar(@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(pedido));
    }

    @PutMapping( "/actualizar" )
    public ResponseEntity<?> actualizar( @RequestBody Pedido pedido ){
        return ResponseEntity.status( HttpStatus.OK ).body( service.actualizar(pedido) );
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.eliminar(id));
    }
}
