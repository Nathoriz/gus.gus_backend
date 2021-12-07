package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.NotFound;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Producto;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProductoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductoService {

    @Autowired
    private ProductoRespository productoRespository;

    public List<Producto> ListarProductos(){
        return productoRespository.findAll();
    }
    public List<Producto> listaPorCategoria( String categoria ){
        List<Producto> producto =  productoRespository.findProductoByCategoriaNombre( categoria );

        if( producto.isEmpty() ){
            return producto;
        }

        return producto;
    }
    public List<Producto> filtroProductos( String nombre ){
        List<Producto>  lista = productoRespository.findAllByNombreContainingIgnoreCase( nombre );
        if( lista.isEmpty() ) throw new NotFound( "404" );
        return lista;
    }
}
