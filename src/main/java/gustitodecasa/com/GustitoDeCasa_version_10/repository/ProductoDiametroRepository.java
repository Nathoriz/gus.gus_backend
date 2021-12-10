package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoDiametro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoDiametroRepository extends JpaRepository<ProductoDiametro, Long> {
    List<ProductoDiametro> findAllByProducto_Id(Long id);
}
