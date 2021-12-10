package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoCubierta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoCubiertaRepository extends JpaRepository<ProductoCubierta,Long> {
    ProductoCubierta findByProducto_Id(Long id);
}
