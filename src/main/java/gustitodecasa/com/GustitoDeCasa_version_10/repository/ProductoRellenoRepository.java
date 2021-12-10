package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoRelleno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRellenoRepository extends JpaRepository<ProductoRelleno,Long> {
    List<ProductoRelleno> findAllByProducto_Id(Long id);
}
