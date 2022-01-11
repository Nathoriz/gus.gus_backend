package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.DetallePedido;
import gustitodecasa.com.GustitoDeCasa_version_10.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detallepedidos")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService service;

    @GetMapping( "/listar" )
    public ResponseEntity<?> listarDetallePedidos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDetallePedido(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @GetMapping("pedido/{id}")
    public ResponseEntity<?> listarPorPedidoID(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarPorPedidoID(id));
    }

    @PostMapping( "/registrar" )
    public ResponseEntity<?> guardarDetallePedido(@RequestBody DetallePedido detallePedido){
        return ResponseEntity.status(HttpStatus.OK).body(service.guardar(detallePedido));
    }

    @PutMapping( "/actualizar" )
    public ResponseEntity<?> actualizarDetallePedido( @RequestBody DetallePedido detallePedido ){
        return ResponseEntity.status( HttpStatus.OK ).body( service.actualizar(detallePedido));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarDetallePedido(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.eliminar(id));
    }
}
