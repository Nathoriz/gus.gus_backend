package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.*;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.CubiertaRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoCubiertaRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductoCubiertaService {
    @Autowired
    private ProductoCubiertaRepository repository;
    @Autowired
    private ProductoRespository productoRepository;
    @Autowired
    private CubiertaRepository cubiertaRepository;

    public List<ProductoCubierta> listar(){
        return repository.findAll();
    }

    public ProductoCubierta guardar(ProductoCubierta productoCubierta){
        Producto producto = productoRepository.findById(productoCubierta.getProducto().getId()).orElse(null);
        Cubierta cubierta = cubiertaRepository.findById(productoCubierta.getCubierta().getId()).orElse(null);

        if(producto.equals(null)) throw new BadRequest("Ingrese producto");
        else productoCubierta.setProducto(producto);
        if(cubierta.equals(null)) throw new BadRequest("Ingrese cubierta");
        else productoCubierta.setCubierta(cubierta);

        return repository.save(productoCubierta);
    }

    public ResponseEntity<?> actualizar(ProductoCubierta productoCubierta){
        ProductoCubierta object = repository.findById(productoCubierta.getId()).orElse(null);
        if(!object.equals(null)){
            object.setProducto(productoCubierta.getProducto());
            object.setCubierta(productoCubierta.getCubierta());
            repository.save(productoCubierta);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public ProductoCubierta buscar(Long id){
        return repository.findById(id).orElse(null);
    }

    public ResponseEntity<?>  eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        ProductoCubierta productoCubierta = repository.findById(id).orElse(null);
        if (productoCubierta.equals(null)) {
            message.put("Mensaje", "La cubierta no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
