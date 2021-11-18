package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Producto;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRespository productoRespository;

    public List<Producto> ListarProductos(){
        return productoRespository.findAll();
    }
}
