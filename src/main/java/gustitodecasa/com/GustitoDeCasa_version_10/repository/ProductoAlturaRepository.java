package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoAltura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoAlturaRepository extends JpaRepository<ProductoAltura, Long> {
    ProductoAltura findProductoAlturaByProducto_Id(Long id);
}
