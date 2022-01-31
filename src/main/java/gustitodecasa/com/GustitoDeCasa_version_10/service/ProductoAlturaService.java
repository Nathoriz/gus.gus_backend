package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Altura;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Producto;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoAltura;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.AlturaRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoAlturaRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductoAlturaService {
    @Autowired
    private ProductoAlturaRepository repository;
    @Autowired
    private ProductoRespository productoRepository;
    @Autowired
    private AlturaRepository alturaRepository;

    public List<ProductoAltura> listar(){
        return repository.findAll();
    }

    public ProductoAltura guardar(ProductoAltura productoAltura){
        Producto producto = productoRepository.findById(productoAltura.getProducto().getId()).orElse(null);
        Altura altura = alturaRepository.findById(productoAltura.getAltura().getId()).orElse(null);

        if(producto.equals(null)) throw new BadRequest("Ingrese producto");
        else productoAltura.setProducto(producto);
        if(altura.equals(null)) throw new BadRequest("Ingrese altura");
        else productoAltura.setAltura(altura);

        return repository.save(productoAltura);
    }

    public ResponseEntity<?> actualizar(ProductoAltura productoAltura){
        ProductoAltura object = repository.findById(productoAltura.getId()).orElse(null);
        if(!object.equals(null)){
            object.setProducto(productoAltura.getProducto());
            object.setAltura(productoAltura.getAltura());
            repository.save(productoAltura);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public ProductoAltura buscar(Long id){
        return repository.findById(id).orElse(null);
    }

    public ResponseEntity<?>  eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        ProductoAltura productoAltura = repository.findById(id).orElse(null);
        if (productoAltura.equals(null)) {
            message.put("Mensaje", "La altura no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
