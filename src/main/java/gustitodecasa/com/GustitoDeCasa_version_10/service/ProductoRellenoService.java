package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.*;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoRellenoRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoRespository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.RellenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductoRellenoService {
    @Autowired
    private ProductoRellenoRepository repository;
    @Autowired
    private ProductoRespository productoRepository;
    @Autowired
    private RellenoRepository rellenoRepository;

    public List<ProductoRelleno> listar(Long id){
        return repository.findAllByProducto_Id(id).orElse(null);
    }

    public ProductoRelleno guardar(ProductoRelleno productoRelleno){
        Producto producto = productoRepository.findById(productoRelleno.getProducto().getId()).orElse(null);
        Relleno relleno = rellenoRepository.findById(productoRelleno.getRelleno().getId()).orElse(null);

        if(producto.equals(null)) throw new BadRequest("Ingrese producto");
        else productoRelleno.setProducto(producto);
        if(relleno.equals(null)) throw new BadRequest("Ingrese cubierta");
        else productoRelleno.setRelleno(relleno);

        return repository.save(productoRelleno);
    }

    public ResponseEntity<?> actualizar(ProductoRelleno productoRelleno){
        ProductoRelleno object = repository.findById(productoRelleno.getId()).orElse(null);
        if(!object.equals(null)){
            object.setProducto(productoRelleno.getProducto());
            object.setRelleno(productoRelleno.getRelleno());
            repository.save(productoRelleno);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public ProductoRelleno buscar(Long id){
        return repository.findById(id).orElse(null);
    }

    public ResponseEntity<?>  eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        ProductoRelleno productoRelleno = repository.findById(id).orElse(null);
        if (productoRelleno.equals(null)) {
            message.put("Mensaje", "El relleno no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
