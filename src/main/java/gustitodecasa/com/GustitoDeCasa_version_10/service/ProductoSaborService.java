package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.*;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoRespository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoSaborRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.SaborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductoSaborService {
    @Autowired
    private ProductoSaborRepository repository;
    @Autowired
    private ProductoRespository productoRepository;
    @Autowired
    private SaborRepository saborRepository;

    public List<ProductoSabor> listar(Long id){
        return repository.findAllByProducto_Id(id).orElse(null);
    }

    public ProductoSabor guardar(ProductoSabor productoSabor){
        Producto producto = productoRepository.findById(productoSabor.getProducto().getId()).orElse(null);
        Sabor sabor = saborRepository.findById(productoSabor.getSabor().getId()).orElse(null);

        if(producto.equals(null)) throw new BadRequest("Ingrese producto");
        else productoSabor.setProducto(producto);
        if(sabor.equals(null)) throw new BadRequest("Ingrese sabor");
        else productoSabor.setSabor(sabor);

        return repository.save(productoSabor);
    }

    public ResponseEntity<?> actualizar(ProductoSabor productoSabor){
        ProductoSabor object = repository.findById(productoSabor.getId()).orElse(null);
        if(!object.equals(null)){
            object.setProducto(productoSabor.getProducto());
            object.setSabor(productoSabor.getSabor());
            repository.save(productoSabor);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public ProductoSabor buscar(Long id){
        return repository.findById(id).orElse(null);
    }

    public ResponseEntity<?>  eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        ProductoSabor productoSabor = repository.findById(id).orElse(null);
        if (productoSabor.equals(null)) {
            message.put("Mensaje", "El sabor no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
