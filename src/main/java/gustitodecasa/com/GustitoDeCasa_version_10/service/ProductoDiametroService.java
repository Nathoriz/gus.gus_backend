package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.*;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.DiametroRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoDiametroRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductoDiametroService {
    @Autowired
    private ProductoDiametroRepository repository;
    @Autowired
    private ProductoRespository productoRepository;
    @Autowired
    private DiametroRepository diametroRepository;

    public List<ProductoDiametro> listar(Long id){
        return repository.findAllByProducto_Id(id).orElse(null);
    }

    public ProductoDiametro guardar(ProductoDiametro productoDiametro){
        Producto producto = productoRepository.findById(productoDiametro.getProducto().getId()).orElse(null);
        Diametro diametro = diametroRepository.findById(productoDiametro.getDiametro().getId()).orElse(null);

        if(producto.equals(null)) throw new BadRequest("Ingrese producto");
        else productoDiametro.setProducto(producto);
        if(diametro.equals(null)) throw new BadRequest("Ingrese cubierta");
        else productoDiametro.setDiametro(diametro);

        return repository.save(productoDiametro);
    }

    public ResponseEntity<?> actualizar(ProductoDiametro productoDiametro){
        ProductoDiametro object = repository.findById(productoDiametro.getId()).orElse(null);
        if(!object.equals(null)){
            object.setProducto(productoDiametro.getProducto());
            object.setDiametro(productoDiametro.getDiametro());
            repository.save(productoDiametro);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public ProductoDiametro buscar(Long id){
        return repository.findById(id).orElse(null);
    }

    public ResponseEntity<?>  eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        ProductoDiametro productoDiametro = repository.findById(id).orElse(null);
        if (productoDiametro.equals(null)) {
            message.put("Mensaje", "El diametro no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
