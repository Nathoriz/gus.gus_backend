package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoSabor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoSaborRepository extends JpaRepository<ProductoSabor,Long> {
    List<ProductoSabor> findAllByProducto_Id(Long id);
}
