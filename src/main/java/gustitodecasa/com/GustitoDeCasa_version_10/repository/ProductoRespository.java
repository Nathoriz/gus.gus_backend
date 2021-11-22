package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRespository extends JpaRepository<Producto, Long> {
    List<Producto> findProductoByCategoriaNombre( String nombre );
}
