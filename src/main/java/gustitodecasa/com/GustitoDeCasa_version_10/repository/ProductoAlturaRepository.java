package gustitodecasa.com.GustitoDeCasa_version_10.repository;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoAltura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductoAlturaRepository extends JpaRepository<ProductoAltura, Long> {
    @Query(value="SELECT p FROM ProductoAltura AS p WHERE p.producto.id = ?1")
    ProductoAltura buscarPorProductoId(Long id);
    public void deleteByProducto_Id(Long id);
    public Optional<List<ProductoAltura>> findAllByProducto_Id(Long id);

    @Query(value="select * from producto_altura as ps where ps.producto_id = ?1 And ps.altura_id <> 1", nativeQuery = true)
    List<ProductoAltura> listarByProductoId(Long id);
}
