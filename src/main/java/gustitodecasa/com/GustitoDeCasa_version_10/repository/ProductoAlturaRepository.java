package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoAltura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductoAlturaRepository extends JpaRepository<ProductoAltura, Long> {
    @Query(value="SELECT p FROM ProductoAltura AS p WHERE p.producto.id = ?1")
    ProductoAltura buscarPorProductoId(Long id);

    Optional<ProductoAltura> findProductoAlturaByProducto_Id(Long id);
    public void deleteByProducto_Id(Long id);
}
